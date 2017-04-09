$(document).ready(function(){
	//为tree做点击事件
	$("#menuTree").tree({
		onClick:function(node){
			var url="";
			var menu=node.text;
			if(menu=="添加报销单"){
				url="addReim.jsp";
			}else if(menu=="申请请假"){
				url='addLeave.jsp';
			}else if(menu=="查看请假"){
				url="showLeaves.jsp";
			}
			
			//判断该选项卡是否存在，不存在创建，存在，则选中
			/*var tab=$("#divTab").tabs("getSelected");
			var title=tab.panel("options").title;
			if(title!=node.text){
				//为选项卡新增一个卡片
				$('#divTab').tabs('add',{
					title: node.text,
					selected: true,
					closable:true,
					href:url
				});
			}*/
			
			var flag=$("#divTab").tabs("exists",menu);
			if(flag){ //存在
				$("#divTab").tabs("select",menu);
			}else{
				//为选项卡新增一个卡片
				$('#divTab').tabs('add',{
					title: menu,
					selected: true,
					closable:true,
					href:url
				});
			}
			
		}
	});
});
