<script src="${ctx.contextPath}/static/jquery/jquery.min.js"></script>
<script src="${ctx.contextPath}/static/bootstrap/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="${ctx.contextPath}/static/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="${ctx.contextPath}/static/css/font-awesome.css">
<link rel="stylesheet" href="${ctx.contextPath}/static/css/font-icons.min.css">
<link rel="stylesheet" href="${ctx.contextPath}/static/plugins/select2/select2.css">
<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
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
   <input type="hidden" class="form-control" id="pageSize" name="pageSize" value="${pageSize}">
  <button type="submit" class="btn btn-default">查询</button>
</form>


<table class="table table-hover">
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
   <#if resultList?exists>  
                <#list resultList as PatientInfo>   
                   <tr>  	
                   		  
                           <td>${PatientInfo.name!''}</td> 
                           <td><#if (PatientInfo.careLevel=='0')>
                           			特级
                           	   <#elseif (PatientInfo.careLevel=='1')>
                           	   		一级
                           	    <#elseif (PatientInfo.careLevel=='2')>
                           	   		二级
                           	    <#elseif (PatientInfo.careLevel=='3')>
                           	   		三级
                           	   <#else>
								 ${PatientInfo.careLevel!''}
  							 </#if>                         
                           </td>  
                           <td>
                           <#if (PatientInfo.auditState)??>
								
                            <#if (PatientInfo.auditState==1)>
                           			未审核
                           	   <#elseif (PatientInfo.auditState==2)>
                           	   		审核通过
                           	    <#elseif (PatientInfo.auditState==3)>
                           	   		驳回                          	
  							 </#if>
  							</#if>
                           </td>  
                           <td>${PatientInfo.beinHospitalTimes!''}</td>  
                           <td>${PatientInfo.inHospitalNo!''}</td>  
                           <td>${PatientInfo.patientType!''}</td>  
                           <td>${PatientInfo.patientDoctor!''}</td>  
                            
                           <td>${PatientInfo.hospitalizationDays!''}</td> 
                           <td>${PatientInfo.diagnoseDoctor!''}</td>
                           <td><#if (PatientInfo.outHospitalFlag==0)>
                           			入院
                           	   <#elseif (PatientInfo.outHospitalFlag==1)>
                           	   		出院
                           	    <#elseif (PatientInfo.outHospitalFlag==2)>
                           	   		未住院                         
                           	   <#else>
								  ${PatientInfo.outHospitalFlag!''}
  							 </#if></td>
  							 <td><a class="btn btn-info" role="button" data-toggle="modal" data-target="#updateModal${PatientInfo.id}">修改</a>
  							 
  							<!-- 模态框（Modal） -->
								<div class="modal fade" id="updateModal${PatientInfo.id}" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
									<div class="modal-dialog">
										<div class="modal-content">
											<div class="modal-header">
												<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
													&times;
												</button>
												<h4 class="modal-title" id="myModalLabel">
													修改病人信息
												</h4>
											</div>
											
											<form action="/api/updatePaitentInfo" method="post">
											
												<div class="form-group row ">
													<div class="col-md-6 mydiv">
													    <label for="exampleInputName2">名字：</label>
													    <input type="text" class="form-control" id="name" name="name" value="${PatientInfo.name!''}">
											  		</div>
												   <div class="col-md-6 mydiv">
													    <label for="exampleInputName2">护理级别：</label>
													     <select class="form-control " name="careLevel" id="careLevel" value="<#if (PatientInfo.careLevel=='0')>
																								                           			特级
																								                           	   <#elseif (PatientInfo.careLevel=='1')>
																								                           	   		一级
																								                           	    <#elseif (PatientInfo.careLevel=='2')>
																								                           	   		二级
																								                           	    <#elseif (PatientInfo.careLevel=='3')>
																								                           	   		三级
																								                           	   <#else>
																																 ${PatientInfo.careLevel!''}
																								  							 </#if>">
									                            <option value="0">特级</option>
									                            <option value="1">一级</option>
									                            <option value="2">二级</option>
									                            <option value="3">三级</option>                       
											            </select>
											  		</div>
											    </div>
											    
											    <div class="form-group row ">
													<div class="col-md-6 mydiv">
													    <label for="exampleInputName2">审核状态：</label>
													    <select class="form-control " name="auditState" id="auditState" value=" <#if (PatientInfo.auditState)??>
								
																										                            <#if (PatientInfo.auditState==1)>
																										                           			未审核
																										                           	   <#elseif (PatientInfo.auditState==2)>
																										                           	   		审核通过
																										                           	    <#elseif (PatientInfo.auditState==3)>
																										                           	   		驳回                          	
																										  							 </#if>
																										  							</#if>">
									                            <option value="1">未审核</option>
									                            <option value="2">审核通过</option>
									                            <option value="3">驳回</option>
											            </select>
											  		</div>
												   <div class="col-md-6 mydiv">
													    <label for="exampleInputName2">住院次数：</label>
													    <input type="number" min="1" max="100" class="form-control" id="beinHospitalTimes" name="beinHospitalTimes" value="${PatientInfo.beinHospitalTimes!''}">
											  		</div>
											    </div>
											    
											    <div class="form-group row ">
													<div class="col-md-6 mydiv">
													    <label for="exampleInputName2">住院号：</label>
													    <input type="text" class="form-control" id="inHospitalNo" name="inHospitalNo" value="${PatientInfo.inHospitalNo!''}">
											  		</div>
												   <div class="col-md-6 mydiv">
													    <label for="exampleInputName2">病人类型：</label>
													    <input type="text" class="form-control" id="patientType" name="patientType" value="${PatientInfo.patientType!''}">
											  		</div>
											    </div>
											    
											    <div class="form-group row ">
													<div class="col-md-6 mydiv">
													    <label for="exampleInputName2">主管医生：</label>
													    <input type="text" class="form-control" id="patientDoctor" name="patientDoctor" value="${PatientInfo.patientDoctor!''}">
											  		</div>
												   <div class="col-md-6 mydiv">
													    <label for="exampleInputName2">住院天数：</label>
													    <input type="number"  min="1" max="1000" class="form-control" id="hospitalizationDays" name="hospitalizationDays" value="${PatientInfo.hospitalizationDays!''}">
											  		</div>
											    </div>
											    
											    <div class="form-group row ">
													<div class="col-md-6 mydiv">
													    <label for="exampleInputName2">住院医生：</label>
													    <input type="text" class="form-control" id="diagnoseDoctor" name="diagnoseDoctor" value="${PatientInfo.diagnoseDoctor!''}">
											  		</div>
												   <div class="col-md-6 mydiv">
													    <label for="exampleInputName2">入院状态：</label>
													     <select class="form-control " name="outHospitalFlag" id="outHospitalFlag" value="<#if (PatientInfo.outHospitalFlag==0)>
																											                           			入院
																											                           	   <#elseif (PatientInfo.outHospitalFlag==1)>
																											                           	   		出院
																											                           	    <#elseif (PatientInfo.outHospitalFlag==2)>
																											                           	   		未住院                         
																											                           	   <#else>
																																			  ${PatientInfo.outHospitalFlag!''}
																											  							 </#if>">
										                            <option value="0">入院</option>
									                            <option value="1">出院</option>
									                            <option value="2">未住院  </option>
											            </select>
											  		</div>
											  		
											    </div>
												<div class="modal-footer">
													<button type="button" class="btn btn-default clo" data-dismiss="modal">关闭</button>
													<button type="submit" class="btn btn-primary sub">保存</button>
												</div>
											
											</form>
											
										</div><!-- /.modal-content -->
									</div><!-- /.modal -->
								</div>
  							 
  							 
  							 
  							 
  							 
  							 
  							 
  							 	<a class="btn btn-danger"  role="button" data-toggle="modal" data-target="#myModal${PatientInfo.id}">删除</a>
  							 	<!-- 模态框（Modal） -->
							<div class="modal fade" id="myModal${PatientInfo.id}" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
								<div class="modal-dialog">
									<div class="modal-content">
										
										<div class="modal-body">
											<h3><div id="delete">确认要删除该记录吗？</div></h3>
										</div>
										<div class="modal-footer">
											<button type="button" class="btn btn-default clo" data-dismiss="modal">取消
											</button>
											<a href="/api/deletePatientById?id=${PatientInfo.id}" type="button" class="btn btn-primary sub">
												确认
											</a>
										</div>
									</div><!-- /.modal-content -->
								</div><!-- /.modal -->
							</div>
							
  							 	<a class="btn btn-success" role="button" data-toggle="modal" data-target="#addModal">新增</a>
  							 </td>
                   </tr>  
                </#list>  
            </#if> 
   
</table>
<nav aria-label="Page navigation">
  <ul class="pagination">
    <li>
     <a href="/api/pagePientList?pageNo=${pageNo-1}&pageSize=${pageSize}">
     	  上一页
      </a>
    </li>
      
    <li>当前第${pageNo}页</li>
    <li>共${pageCnt}页</li>
    <li>每页${pageSize}条</a></li>
    <li>共${totalCnt}条记录</li>
    <li>
      <a href="/api/pagePientList?pageNo=${pageNo+1}&pageSize=${pageSize}">
       	下一页
      </a>
    </li>
  </ul>
</nav>
<!-- 模态框（Modal） -->
<div class="modal fade" id="addModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
					&times;
				</button>
				<h4 class="modal-title" id="myModalLabel">
					新增病人信息
				</h4>
			</div>
			
			<form action="/api/addPaitentInfo" method="post">
			
				<div class="form-group row ">
					<div class="col-md-6 mydiv">
					    <label for="exampleInputName2">名字：</label>
					    <input type="text" class="form-control" id="name" name="name">
			  		</div>
				   <div class="col-md-6 mydiv">
					    <label for="exampleInputName2">护理级别：</label>
					     <select class="form-control " name="careLevel" id="careLevel">
	                            <option value="0">特级</option>
	                            <option value="1">一级</option>
	                            <option value="2">二级</option>
	                            <option value="3">三级</option>                       
			            </select>
			  		</div>
			    </div>
			    
			    <div class="form-group row ">
					<div class="col-md-6 mydiv">
					    <label for="exampleInputName2">审核状态：</label>
					    <select class="form-control " name="auditState" id="auditState">
	                            <option value="1">未审核</option>
	                            <option value="2">审核通过</option>
	                            <option value="3">驳回</option>
			            </select>
			  		</div>
				   <div class="col-md-6 mydiv">
					    <label for="exampleInputName2">住院次数：</label>
					    <input type="number" name="points" min="1" max="100" class="form-control" id="beinHospitalTimes" name="beinHospitalTimes">
			  		</div>
			    </div>
			    
			    <div class="form-group row ">
					<div class="col-md-6 mydiv">
					    <label for="exampleInputName2">住院号：</label>
					    <input type="text" class="form-control" id="inHospitalNo" name="inHospitalNo">
			  		</div>
				   <div class="col-md-6 mydiv">
					    <label for="exampleInputName2">病人类型：</label>
					    <input type="text" class="form-control" id="patientType" name="patientType">
			  		</div>
			    </div>
			    
			    <div class="form-group row ">
					<div class="col-md-6 mydiv">
					    <label for="exampleInputName2">主管医生：</label>
					    <input type="text" class="form-control" id="patientDoctor" name="patientDoctor">
			  		</div>
				   <div class="col-md-6 mydiv">
					    <label for="exampleInputName2">住院天数：</label>
					    <input type="number" name="points" min="1" max="1000" class="form-control" id="hospitalizationDays" name="hospitalizationDays">
			  		</div>
			    </div>
			    
			    <div class="form-group row ">
					<div class="col-md-6 mydiv">
					    <label for="exampleInputName2">住院医生：</label>
					    <input type="text" class="form-control" id="diagnoseDoctor" name="diagnoseDoctor">
			  		</div>
				   <div class="col-md-6 mydiv">
					    <label for="exampleInputName2">入院状态：</label>
					     <select class="form-control " name="outHospitalFlag" id="outHospitalFlag">
	                            <option value="0">入院</option>
	                            <option value="1">出院</option>
	                            <option value="2">未住院  </option>
			            </select>
			  		</div>
			  		
			    </div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default clo" data-dismiss="modal">关闭</button>
					<button type="submit" class="btn btn-primary sub">保存</button>
				</div>
			
			</form>
			
		</div><!-- /.modal-content -->
	</div><!-- /.modal -->
</div>

<button type="button" class="close" data-dismiss="alert" aria-label="Close">
  <span aria-hidden="true">&times;</span>
</button>