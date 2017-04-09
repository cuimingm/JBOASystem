$(document).ready(function(){
	
	//显示请假信息
	$("#leavesTable").datagrid({
		 url:'showLeave.action',  
		 fit:true,
		 fitColumns:true,
		 rownumbers:true,
		 singleSelect:true,
		 pageList:[5,10,15],
		 pagination:true,
		 columns:[[    
		     /*{field:'leaveNo',title:'编号',width:50}, */   
		     {field:'name',title:'名称',width:120},    
		     {field:'createTime',title:'发起时间',width:100},
		     {field:'leaveEmpName',title:'请假人',width:100},
		     {field:'leaveDeptName',title:'所属部门',width:100},
		     {field:'checkTime',title:'审批时间',width:100},
		     {field:'checkIdea',title:'审批意见',width:100},
		     {field:'jobName',title:'职务',width:100,hidden:true},
		     {field:'leaveState',title:'审批状态',width:100},
		     {field:'leaveNo',title:'操作',align:'center',width:100,
		    	 formatter: function(value,row,index){
		    		 	var text="<a href='#' onClick='optionIt("+value+",1);'>详情</a>";
		    		 	if(row.jobName=="部门经理" && row.leaveState=="待审核")
		    		 		text+="&nbsp;<img src='images/play.gif' onClick='optionIt("+value+",2);'/>";
						return text;
				}
		     }
		 ]]    

	});
	
	//设置日期格式
	/*$("#txtLeaveStart,#txtLeaveEnd").datebox({
		formatter:function(date){
			var y = date.getFullYear();
			var m = date.getMonth()+1;
			var d = date.getDate();
			return y+'-'+m+'-'+d;
		}
	});*/
	//点击添加按钮
	$("#btnAddLeave").linkbutton({
		onClick:function(){
			//提交表单
			$("#addLeaveForm").form('submit', {    
			    url:"addLeave.action",     
			    success:function(data){    
			        if(data=="ok"){
			        	$.messager.alert('提示','申请提交成功！');    
			        }else{
			        	$.messager.show({
			        		title:'提示',
			        		msg:'请假申请提交失败！',
			        		timeout:5000,
			        		showType:'slide'
			        	});

			        }   
			    }    
			});
		}
	});
});

//有函数名的在ready外定义
/**
 * 处理：显示详情或者审核
 */
function optionIt(leaveNo,option){
	var title="显示请假详情";
	if(option==2)
		title="审核请假";
	var url="checkLeave.jsp?option="+option+"&leaveNo="+leaveNo;
	var flag=$("#divTab").tabs("exists",title);
	if(flag){ //存在
		$("#divTab").tabs("select",menu);
	}else{
		//为选项卡新增一个卡片
		$('#divTab').tabs('add',{
			title: title,
			selected: true,
			closable:true,
			href:url
		});
	}
}


