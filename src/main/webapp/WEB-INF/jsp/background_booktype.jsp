<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>后台管理 - 图书类型</title>
	<link rel="stylesheet" href="<%=basePath%>resource/bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" href="<%=basePath%>resource/bootstrap-table/bootstrap-table.css">
	<link rel="stylesheet" href="<%=basePath%>resource/bootstrap-fileinput/css/fileinput.min.css">
	<script src="<%=basePath%>resource/jquery/jquery-3.3.1.min.js"></script>
	<script src="<%=basePath%>resource/bootstrap/js/bootstrap.min.js"></script>
	<script src="<%=basePath%>resource/bootstrap-table/bootstrap-table.js"></script>
	<script src="<%=basePath%>resource/bootstrap-table/locale/bootstrap-table-zh-CN.js"></script>
	<script src="<%=basePath%>resource/bootstrap-fileinput/js/fileinput.min.js"></script>
	<script src="<%=basePath%>resource/bootstrap-fileinput/js/locales/zh.js"></script>
</head>
<body>
	<div class="container" style="margin-top:80px">
        <div class="row">
        	<h2>图书类型</h2>
        	<div class="col-xs-6 pull-left">
        		<button type="button" class="btn btn-primary" onclick="addType_Click()">添加</button>
        	</div>
            <!-- 表格 -->
            <div class="col-xs-12">
                <table class="table table-striped table-bordered table-hover" id="table" ></table>
            </div>
        </div>
    </div>
    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">结果</h4>
				</div>
				<div class="modal-body">
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
				</div>
			</div>
		</div>
	</div>
	
	<script type="text/javascript">
		class BstpTable{
				constructor(obj) {
					this.obj=obj;
				}
				inint(){
			         this.obj.bootstrapTable('destroy');  
					 this.obj.bootstrapTable({
				    	url: "<%=basePath%>api/bookType/get",
						method: "post",
						contentType: "application/x-www-form-urlencoded",
						/* queryParamsType的默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
			                              设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber */
			            queryParamsType:"", 
			            queryParams: function queryParams(params) {  
			              var param = {  
			                  pageNumber: params.pageNumber,    
			                  pageSize: params.pageSize
			              };
			              return param;                   
			            }, 
						//【其它设置】
						locale:"zh-CN",//中文支持
						pagination: true,//是否开启分页（*）
			            pageNumber:1,//初始化加载第一页，默认第一页
			            pageSize: 20,//每页的记录行数（*）
			            pageList: [10, 20, 50],
			            sidePagination: "server", //分页方式：client客户端分页，server服务端分页（*）
			            showRefresh:true,//刷新按钮
			            clickToSelect: true, 
			            //【设置列】
						columns: [
						 {field: 'typeId',title: '主键'}, 
						 {field: 'typeName',title: '类型名称'},
						 {field: 'tool',title: '操作', align: 'center',
							formatter:function(value,row,index){
							    var element = 
							    	'<button type=\'button\' class=\'btn btn-primary\' onclick=\'deleteClick(\"' + row.typeId + '\")\'>删除</button>&nbsp;' 
							    	+'<button type=\'button\' class=\'btn btn-primary\' onclick=\'updateClick(\"' + row.typeId + '\")\'>修改</button>';
							    return element;  
							} 
						  }
						],
						
						responseHandler:function (res) {
			                return res.data;
			            },

			        })
				 }
			}
			
			var bstpTable=new BstpTable($("table"));
			bstpTable.inint({});
			
			function deleteClick(typeId){
				$.ajax({
					type : 'POST',
					url : '<%=basePath%>api/bookType/delete',
					dataType : 'json',
					data : { "typeId" : typeId},
					success : function(data){
						if(data.statu == 1){
							$('#table').bootstrapTable('refresh');
						}
						showMessage(data.message);
					},
					error : function(){
						showMessage("请求失败");
					}
				})
			}
			
			function updateClick(typeId){
				
			}
			
			function addType_Click(){
				
			}
			
			function showMessage(message){
				$('#myModal').find('.modal-body').text(message);
				$('#myModal').modal('show');
			}
	</script>
</body>
</html>