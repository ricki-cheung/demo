<script src="${ctx.contextPath}/static/jquery/jquery.min.js"></script>
<script src="${ctx.contextPath}/static/bootstrap/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="${ctx.contextPath}/static/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="${ctx.contextPath}/static/css/font-awesome.css">
<link rel="stylesheet" href="${ctx.contextPath}/static/css/font-icons.min.css">
<link rel="stylesheet" href="${ctx.contextPath}/static/plugins/select2/select2.css">
<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="http://www.jq22.com/jquery/jquery-1.10.2.js"></script>
<script src="${ctx.contextPath}/static/jqueryPlugPop/plug-in.min.js"></script>
<script type="text/javascript">
	function loadPaitenInfo(){
		$.ajax({
			url:"/api/getPatientInfo",
			type:"GET",
			dataType:"json",
			success:function(data){
				var str = null;
				var deleteId;
				var updateAddDelete ='';
				var setModal = '';
				var addModal = '';
				var deleteModal = '';
				for(var i=0;i<data.length;i++){
					var name ; 
					if(data[i].name != null){name = data[i].name;}else{name = "";}
					var careLevel ; 
					if(data[i].careLevel != null){careLevel = data[i].careLevel;}else{careLevel = "";}
					var auditState ; 
					if(data[i].auditState != null){auditState = data[i].auditState;}else{auditState = "";}
					var beinHospitalTimes ; 
					if(data[i].beinHospitalTimes != null){beinHospitalTimes = data[i].beinHospitalTimes;}else{beinHospitalTimes = "";}
					var inHospitalNo ; 
					if(data[i].inHospitalNo != null){inHospitalNo = data[i].inHospitalNo;}else{inHospitalNo = "";}
					var patientType ; 
					if(data[i].patientType != null){patientType = data[i].patientType;}else{patientType = "";}
					var patientDoctor ; 
					if(data[i].patientDoctor != null){patientDoctor = data[i].patientDoctor;}else{patientDoctor = "";}
					var hospitalizationDays ; 
					if(data[i].hospitalizationDays != null){hospitalizationDays = data[i].hospitalizationDays;}else{hospitalizationDays = "";}
					var diagnoseDoctor ; 
					if(data[i].diagnoseDoctor != null){diagnoseDoctor = data[i].diagnoseDoctor;}else{diagnoseDoctor = "";}
					var outHospitalFlag ; 
					if(data[i].outHospitalFlag != null){outHospitalFlag = data[i].outHospitalFlag;}else{outHospitalFlag = "";}
					
					updateAddDelete ='<a class="btn btn-info" role="button" data-toggle="modal" data-target="#updateModal'+data[i].id+'">修改</a>'
				 				+'<a class="btn btn-success" role="button" data-toggle="modal" data-target="#addModal">新增</a>'
								+'<a class="btn btn-danger"  role="button" onclick="toDelete('+data[i].id+')">删除</a>';
					
					
					str+="<tr id='"+data[i].id+"'>";
					str+="<td>"+name+"</td>";
					str+="<td>"+careLevel+"</td>";
					str+="<td>"+auditState+"</td>";
					str+="<td>"+beinHospitalTimes+"</td>";
					str+="<td>"+inHospitalNo+"</td>";
					str+="<td>"+patientType+"</td>";
					str+="<td>"+patientDoctor+"</td>";
					str+="<td>"+hospitalizationDays+"</td>";
					str+="<td>"+diagnoseDoctor+"</td>";
					str+="<td>"+outHospitalFlag+"</td>";
					str+="<td>"+updateAddDelete+"</td>";
					str+="</tr>";
					
					setModal ='<div class="modal fade" id="updateModal'+data[i].id+'" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">'
						+'<div class="modal-dialog">'
							+'<div class="modal-content">'
								+'<div class="modal-header">'
									+'<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>'
									+'<h4 class="modal-title" id="myModalLabel">修改病人信息</h4></div>'
								+'<form action="/api/#" method="post">'
									+'<div class="form-group row ">'
										+'<div class="col-md-6 mydiv">'
											+'<label for="exampleInputName2">名字：</label>'
											+'<input type="hidden" value="'+data[i].id+'" name="id">'
											+'<input type="text" class="form-control" id="name" name="name" value="'+name+'">'
										+'</div>'
										+'<div class="col-md-6 mydiv">'
											+'<label for="exampleInputName2">护理级别：</label>'
											+'<select class="form-control " name="careLevel" id="careLevel" value="'+careLevel+'">'
											                            +'<option value=" 0 ">特级</option>'
											                            +'<option value="1 ">一级</option>'
											                            +'<option value="2 ">二级</option>'
											                            +'<option value="3 ">三级</option>'                       
											+'</select>'
										+'</div>'
									+'</div>'			    
									+'<div class="form-group row ">'
										+'<div class="col-md-6 mydiv ">'
											+'<label for="exampleInputName2 ">审核状态：</label>'
											+'<select class="form-control " name="auditState " id="auditState " value="'+auditState+' ">'
														    +'<option value="1 ">未审核</option>'
														    +'<option value="2 ">审核通过</option>'
														    +'<option value="3 ">驳回</option>'
											+'</select>'
										+'</div>'
										+'<div class="col-md-6 mydiv ">'
											+'<label for="exampleInputName2 ">住院次数：</label>'
											+'<input type="number " min="1 " max="100 " class="form-control " id="beinHospitalTimes " name="beinHospitalTimes " value="'+beinHospitalTimes+' ">'
										+'</div>'
									+'</div>'		    
									+'<div class="form-group row ">'
										+'<div class="col-md-6 mydiv ">'
											+'<label for="exampleInputName2 ">住院号：</label>'
											+'<input type="text " class="form-control " id="inHospitalNo " name="inHospitalNo " value="'+inHospitalNo+'">'
										+'</div>'
										+'<div class="col-md-6 mydiv ">'
											+'<label for="exampleInputName2 ">病人类型：</label>'
											+'<input type="text " class="form-control " id="patientType " name="patientType " value="'+patientType+' ">'
										+'</div>'
									+'</div>'				    
									+'<div class="form-group row ">'
										+'<div class="col-md-6 mydiv ">'
											+'<label for="exampleInputName2 ">主管医生：</label>'
											+'<input type="text " class="form-control " id="patientDoctor " name="patientDoctor " value="'+patientDoctor+'">'
										+'</div>'
										+'<div class="col-md-6 mydiv ">'
											+'<label for="exampleInputName2 ">住院天数：</label>'
											+'<input type="number "  min="1 " max="1000 " class="form-control " id="hospitalizationDays " name="hospitalizationDays " value="'+hospitalizationDays+'">'
										+'</div>'
									+'</div>'				    
									+'<div class="form-group row ">'
										+'<div class="col-md-6 mydiv ">'
											+'<label for="exampleInputName2 ">住院医生：</label>'
											+'<input type="text " class="form-control " id="diagnoseDoctor " name="diagnoseDoctor " value="'+diagnoseDoctor+'">'
										+'</div>'
										+'<div class="col-md-6 mydiv ">'
											+'<label for="exampleInputName2 ">入院状态：</label>'
											+'<select class="form-control " name="outHospitalFlag " id="outHospitalFlag " value=" ">'
													+'<option value="0 ">入院</option>'
													+'<option value="1 ">出院</option>'
													+'<option value="2 ">未住院  </option>'
											+'</select>'
										+'</div>'				  		
									+'</div>'
									+'<div class="modal-footer ">'
										+'<button type="button " class="btn btn-default clo " data-dismiss="modal ">关闭</button>'
										+'<button type="submit " class="btn btn-primary sub ">保存</button>'
									+'</div>'					
								+'</form>'						
							+'</div>'
						+'</div>'
					+'</div>';
					
					
					$("#stuid tbody").append(setModal);
					
				}
				
				addModal = '<div class="modal fade" id="addModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">'
						+'<div class="modal-dialog">'
							+'<div class="modal-content">'
								+'<div class="modal-header">'
									+'<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>'
									+'<h4 class="modal-title" id="myModalLabel">新增病人信息</h4></div>'
								+'<form action="/api/#" method="post">'
									+'<div class="form-group row ">'
										+'<div class="col-md-6 mydiv">'
											+'<label for="exampleInputName2">名字：</label>'
											
											+'<input type="text" class="form-control" id="name" name="name">'
										+'</div>'
										+'<div class="col-md-6 mydiv">'
											+'<label for="exampleInputName2">护理级别：</label>'
											+'<select class="form-control " name="careLevel" id="careLevel" >'
											                            +'<option value=" 0 ">特级</option>'
											                            +'<option value="1 ">一级</option>'
											                            +'<option value="2 ">二级</option>'
											                            +'<option value="3 ">三级</option>'                       
											+'</select>'
										+'</div>'
									+'</div>'			    
									+'<div class="form-group row ">'
										+'<div class="col-md-6 mydiv ">'
											+'<label for="exampleInputName2 ">审核状态：</label>'
											+'<select class="form-control " name="auditState " id="auditState " >'
														    +'<option value="1 ">未审核</option>'
														    +'<option value="2 ">审核通过</option>'
														    +'<option value="3 ">驳回</option>'
											+'</select>'
										+'</div>'
										+'<div class="col-md-6 mydiv ">'
											+'<label for="exampleInputName2 ">住院次数：</label>'
											+'<input type="number " min="1 " max="100 " class="form-control " id="beinHospitalTimes " name="beinHospitalTimes " >'
										+'</div>'
									+'</div>'		    
									+'<div class="form-group row ">'
										+'<div class="col-md-6 mydiv ">'
											+'<label for="exampleInputName2 ">住院号：</label>'
											+'<input type="text " class="form-control " id="inHospitalNo " name="inHospitalNo " >'
										+'</div>'
										+'<div class="col-md-6 mydiv ">'
											+'<label for="exampleInputName2 ">病人类型：</label>'
											+'<input type="text " class="form-control " id="patientType " name="patientType " >'
										+'</div>'
									+'</div>'				    
									+'<div class="form-group row ">'
										+'<div class="col-md-6 mydiv ">'
											+'<label for="exampleInputName2 ">主管医生：</label>'
											+'<input type="text " class="form-control " id="patientDoctor " name="patientDoctor " >'
										+'</div>'
										+'<div class="col-md-6 mydiv ">'
											+'<label for="exampleInputName2 ">住院天数：</label>'
											+'<input type="number "  min="1 " max="1000 " class="form-control " id="hospitalizationDays " name="hospitalizationDays " >'
										+'</div>'
									+'</div>'				    
									+'<div class="form-group row ">'
										+'<div class="col-md-6 mydiv ">'
											+'<label for="exampleInputName2 ">住院医生：</label>'
											+'<input type="text " class="form-control " id="diagnoseDoctor " name="diagnoseDoctor ">'
										+'</div>'
										+'<div class="col-md-6 mydiv ">'
											+'<label for="exampleInputName2 ">入院状态：</label>'
											+'<select class="form-control " name="outHospitalFlag " id="outHospitalFlag " >'
													+'<option value="0 ">入院</option>'
													+'<option value="1 ">出院</option>'
													+'<option value="2 ">未住院  </option>'
											+'</select>'
										+'</div>'				  		
									+'</div>'
									+'<div class="modal-footer ">'
										+'<button type="button " class="btn btn-default clo " data-dismiss="modal ">关闭</button>'
										+'<button type="submit " class="btn btn-primary sub ">保存</button>'
									+'</div>'					
								+'</form>'						
							+'</div>'
						+'</div>'
					+'</div>';
				  
                $("#stuid tbody").append(str);
                $("#stuid tbody").append(addModal);   
			}
		})
	}
	$(document).ready(function(){
		loadPaitenInfo();
	});
	
	
	function handleDelete(){
		 doDel(id);
	}
	
	
	function doDel(sid){
			$("#myModal"+sid).remove();
			$.ajax({
				type:"GET",
				url:"/api/patientInfoAjax",
				async:true,
				dataType:"json",
				data:{id:sid},
				success:function(data){
					if(data.result == 1){
						$("#"+sid).remove();
					}
				},
				error:function(){
					alert("发生未知错误！")
				}
			});
		}
	
	
	function toDelete(sid){
		id = sid;
		$.Pop('确定要删除吗？','confirm',function(){
			handleDelete();
		})
		
	}
	
</script>
	<style>
		.mydiv{
			padding-left: 4.5%;
			padding-right: 4.5%;
		}
		.clo{
			margin-left: 30%;
			margin-right: 15%;
		}
		.sub{
			margin-left: 13%;
			margin-right: 30%;
		}
		#delete{
			margin-left: 25%;
			margin-right: 25%;
		}
	</style>
<form class="form-inline" action="/api/queryPatientInfo" method="post">
  <div class="form-group ">
    <label for="exampleInputName2">名字：</label>
    <input type="text" class="form-control" id="patientName" name="patientName">
  </div>
  <div class="form-group">
    <label for="exampleInputName2">审核状态：</label>
    <select class="form-control " name="checkStatus" id="checkStatus">
    						<option value="0">请选择</option>
                            <option value="1">未审核</option>
                            <option value="2">审核通过</option>
                            <option value="3">驳回</option>
		            </select>
  </div>
  <div class="form-group">
    <label for="form-group">住院号：</label>
    <input type="text" class="form-control" id="inHospitalNo" name="inHospitalNo">
  </div>
  <div class="form-group">
    <label for="exampleInputName2">病人类型：</label>
    <input type="text" class="form-control" id="patientType" name="patientType">
  </div>
  <div class="form-group">
    <label for="exampleInputName2">主管医生：</label>
    <input type="text" class="form-control" id="patientDoctor" name="patientDoctor">
  </div>
  <div class="form-group">
    <label for="exampleInputName2">护理级别：</label>
   <select class="form-control " name="careLevel" id="careLevel">
   							<option value="请选择">请选择</option>
                            <option value="3">三级</option>
                            <option value="2">二级</option>
                            <option value="1">一级</option>
                            <option value="0">特级</option>
		            </select>
  </div>
   <input type="hidden" class="form-control" id="pageSize" name="pageSize">
  <button type="submit" class="btn btn-default">查询</button>
</form>


<table class="table table-hover" id="stuid">
			<thead>
				<tr>  
				    <th>名字</th>
					<th>护理级别</th>
				    <th>审核状态</th>
				    <th>住院次数</th>
				    <th>住院号</th>
					<th>病人类型</th>
				    <th>主管医生</th>
					<th>住院天数</th>
					<th>住院医生</th>
					<th>入院状态</th>
					<th>操作</th>
	        	</tr>
        	</thead>
        	<tbody>
        		
        	</tbody>
        </table>