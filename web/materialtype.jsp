    <%@page import="inquiry.getUnit"%>
<%@page import="entity.MaterialType"%>
<%@page import="entity.MaterialCategourt"%>
<%@page import="java.util.List"%>
﻿<!DOCTYPE html>
<!--[if IE 8]> <html lang="en" class="ie8"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9"> <![endif]-->
<!--[if !IE]><!--> <html lang="en"> <!--<![endif]-->
    <!-- BEGIN HEAD -->
    <head>
        <meta charset="UTF-8" />
        <title>INSIDER 360</title>
        <%@ page  contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
        <meta content="width=device-width, initial-scale=1.0" name="viewport" />
        <meta content="" name="description" />
        <meta content="" name="author" />
        <!--[if IE]>
           <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
           <![endif]-->
        <!-- GLOBAL STYLES -->
        <link rel="stylesheet" href="assets/plugins/bootstrap/css/bootstrap.css" />
        <link rel="stylesheet" href="assets/css/main.css" />
        <link rel="stylesheet" href="assets/css/theme.css" />
        <link rel="stylesheet" href="assets/css/MoneAdmin.css" />
        <link rel="stylesheet" href="assets/plugins/Font-Awesome/css/font-awesome.css" />
        <!--END GLOBAL STYLES -->

        <!-- PAGE LEVEL STYLES -->
        <link href="assets/css/layout2.css" rel="stylesheet" />
        <link href="assets/plugins/flot/examples/examples.css" rel="stylesheet" />
        <link rel="stylesheet" href="assets/plugins/timeline/timeline.css" />
        <link href="assets/plugins/dataTables/dataTables.bootstrap.css" rel="stylesheet" />
        <link rel="stylesheet" href="assets/plugins/bootstrap/css/bootstrap.css" />
        <link rel="stylesheet" href="assets/css/main.css" />
        <link rel="stylesheet" href="assets/css/theme.css" />
        <link rel="stylesheet" href="assets/css/MoneAdmin.css" />
        <link rel="stylesheet" href="assets/plugins/Font-Awesome/css/font-awesome.css" />
        
        
        

        
        
        
    

        <!-- END PAGE LEVEL  STYLES -->
        <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
          <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
        <![endif]-->
        <script src="http://code.jquery.com/jquery-3.1.0.min.js"></script>
        <script type="text/javascript" src="assets/js/selector.js"></script>

        <script type="text/javascript">

            function proceed() {
                opener.location.reload(true);
                self.close();
            }

           function ram(clickedButton) {
                var $row = $(clickedButton).closest("tr");    // Find the row
                var $text = $row.find(".descc").text(); // Find the text
                var $text1 = $row.find(".idd").text(); // Find the text
                var $text2 = $row.find(".materialCategory").text().trim(); // Find the text
                //alert("$text2 : " + $text2);

                // Let's test it out
                document.getElementById("editevalue").value=$text;
                document.getElementById("edit_unit_id").value=$text1;
                document.getElementById("materialTypeCat").value=$text2;
             
             }
             
               function ram2(clickedButton) {
                var $row = $(clickedButton).closest("tr");    // Find the row
                var $text1 = $row.find(".idd").text(); // Find the text

                // Let's test it out
                document.getElementById("id_value_del").value=$text1;
             }
             
             function checkMaterialExistance(fieldName) {
                 //alert("fieldName : " + fieldName);
                 var exists = false;
                 var materialTypeVar = $("input[name=" + fieldName + "]").val();
                 //alert("materialTypeVar : " + materialTypeVar );
                 jQuery.ajax({
                    url: 'ajax/materialTypeExist.jsp?materialTypeDesc='+materialTypeVar,
                    success: function (result) {
                        //alert(result.trim());
                        if( 'true' == result.trim()){
                            alert(materialTypeVar + " already exists ");
                        }else if( 'false' == result.trim()){
                            exists = true;
                        } 
                    },
                    async: false
                });
                 return exists;
             }
        </script>

    </head>

    <!-- END HEAD -->

    <!-- BEGIN BODY -->
    <body class="padTop53 " >

        <!-- MAIN WRAPPER -->
        <div id="wrap" >


            <!-- HEADER SECTION -->
            <div id="top">

                <nav class="navbar navbar-inverse navbar-fixed-top " style="padding-top: 10px;">
                    <a data-original-title="Show/Hide Menu" data-placement="bottom" data-tooltip="tooltip" class="accordion-toggle btn btn-primary btn-sm visible-xs" data-toggle="collapse" href="#menu" id="menu-toggle">
                        <i class="icon-align-justify"></i>
                    </a>
                    <!-- LOGO SECTION -->
                    <header class="navbar-header">

                        <a href="index.jsp" class="navbar-brand">
                            <img  src="assets/img/logo2.png" alt="" />

                        </a>
                    </header>
                    <!-- END LOGO SECTION -->
                    <ul class="nav navbar-top-links navbar-right">

                        <!-- MESSAGES SECTION -->
                        <li class="dropdown">
                            <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                                <span class="label label-success">2</span>    <i class="icon-envelope-alt"></i>&nbsp; <i class="icon-chevron-down"></i>
                            </a>

                            <ul class="dropdown-menu dropdown-messages">
                                <li>
                                    <a class="text-center" href="#">
                                        <strong>Read All Messages</strong>
                                        <i class="icon-angle-right"></i>
                                    </a>
                                </li>
                            </ul>

                        </li>
                        <!--END MESSAGES SECTION -->

                        <!--TASK SECTION -->
                        <li class="dropdown">
                            <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                                <span class="label label-danger">5</span>   <i class="icon-tasks"></i>&nbsp; <i class="icon-chevron-down"></i>
                            </a>

                            <ul class="dropdown-menu dropdown-tasks">
                                <li>
                                    <a class="text-center" href="#">
                                        <strong>See All Tasks</strong>
                                        <i class="icon-angle-right"></i>
                                    </a>
                                </li>
                            </ul>

                        </li>
                        <!--END TASK SECTION -->

                        <!--ALERTS SECTION -->
                        <li class="chat-panel dropdown">
                            <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                                <span class="label label-info">8</span>   <i class="icon-comments"></i>&nbsp; <i class="icon-chevron-down"></i>
                            </a>

                            <ul class="dropdown-menu dropdown-alerts">

                                <li>
                                    <a href="#">
                                        <div>
                                            <i class="icon-envelope"></i> Messages 
                                            <span class="pull-right text-muted small" > 20 minutes ago</span>
                                        </div>
                                    </a>
                                </li>
                                <li class="divider"></li>
                                <li>
                                    <a href="#">
                                        <div>
                                            <i class="icon-tasks"></i> New Task
                                            <span class="pull-right text-muted small"> 1 Hour ago</span>
                                        </div>
                                    </a>
                                </li>
                                <li class="divider"></li>
                                <li>
                                    <a href="#">
                                        <div>
                                            <i class="icon-upload"></i> Server Rebooted
                                            <span class="pull-right text-muted small"> 2 Hour ago</span>
                                        </div>
                                    </a>
                                </li>
                                <li class="divider"></li>
                                <li>
                                    <a class="text-center" href="#">
                                        <strong>See All Alerts</strong>
                                        <i class="icon-angle-right"></i>
                                    </a>
                                </li>
                            </ul>

                        </li>
                        <!-- END ALERTS SECTION -->

                        <!--ADMIN SETTINGS SECTIONS -->

                        <li class="dropdown">
                            <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                                <i class="icon-user "></i>&nbsp; <i class="icon-chevron-down "></i>
                            </a>

                            <ul class="dropdown-menu dropdown-user">
                                <li><a href="#"><i class="icon-user"></i> User Profile </a>
                                </li>
                                <li><a href="#"><i class="icon-gear"></i> Settings </a>
                                </li>
                                <li class="divider"></li>
                                <li><a href="login.jsp"><i class="icon-signout"></i> Logout </a>
                                </li>
                            </ul>

                        </li>
                        <!--END ADMIN SETTINGS -->
                    </ul>

                </nav>

            </div>
            <!-- END HEADER SECTION -->



            <jsp:include page="left_menu.jsp"></jsp:include>


                <!--PAGE CONTENT -->
                <div id="content">

                    <div class="inner" style="min-height: 1000px;">
                        <div class="row">
                            <div class="col-lg-12">
                                <h5>Material Type Setup</h5>
                            </div>
                        </div>
                        <hr />


                        <div class="row">
                            <div class="col-lg-12">
                                <div class="panel panel-default">
                                    <div class="panel-heading">
                                        Material Type Setup
                                    </div>
                                    <div class="panel-body">
                                        <div class="table-responsive">

                                            <table class="table table-striped table-bordered table-hover" id="dataTables-example">                                                    <thead>
                                                    <tr>
                                                        <th style="display: none;">Type ID</th>
                                                        <th>Material Type Description</th>
                                                        <th>Material Category</th>
                                                        <th>Action</th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <tr>
                                                        <!--<td><label>1</label></td>-->
                                                    <%

                                                        List<MaterialType> rr = new getUnit().getmaterialType();
                                                        for (int i = 0; i < rr.size(); i++) {
                                                    %>
                                                    <td class="idd" style="display: none;"><%=rr.get(i).getMaterialTypeId() %> </td>
                                                    <td class="descc"><%=rr.get(i).getItemTypeDesc() %></td>                                                
                                                    <td class="materialCategory" id="materialCategory">
                                                        <% 
                                                            MaterialCategourt materialCategory = rr.get(i).getMaterialCategory();
                                                            if ( materialCategory != null ) {
                                                                out.print(materialCategory.getMaterialCategouryDesc());
                                                            }
                                                         %>
                                                    </td>                                                
                                                    <td>
                                                        <button type="button" class="btn btn-default btn-sm btn-grad btn-rect use-address" data-target="#buttonedModal2"  data-toggle="modal"  aria-hidden="true"  onclick="ram(this)">EDIT</button>
                                                        <button type="button" class="btn btn-danger btn-sm btn-grad btn-rect use-address" data-target="#buttonedModal"  data-toggle="modal"  aria-hidden="true" onclick="ram2(this)">DEL</button>

                                                    </td>
                                                </tr>
                                                <%
                                                    }

                                                %>

                                            </tbody>

                                        </table>
                                        <div class="panel-body">
                                            <button class="btn btn-info" data-toggle="modal" data-target="#formModal">
                                                add record
                                            </button>

                                        </div>

                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                </div>
                /
            </div>
            <!--END PAGE CONTENT -->

        </div>

        <div class="col-lg-12">
            <div class="modal fade" id="buttonedModal" tabindex="-1" role="dialog"  aria-labelledby="myModalLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                            <h4 class="modal-title" id="H1">Del Material Type</h4>
                        </div>
                        <div class="modal-body">
                            are you confirm to delete this record
                        </div>
                        <div class="modal-footer">
                            <form method="POST" action="materialtype">
                                <input type="hidden" name="id_value_del" id="id_value_del" />
                                <button type="submit" class="btn btn-primary" name="del_material" value="delete">DELETE</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>


        <div class="col-lg-12">
            <div class="modal fade" id="buttonedModal2" tabindex="-1" role="dialog"  aria-labelledby="myModalLabel" aria-hidden="true" >
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                            <h4 class="modal-title" id="H1">Edit Material Type</h4>
                        </div>
                        <form role="form" method="POST" action="materialtype">
                        <div class="modal-body">
                            <input autofocus=""  type="text" class="form-control" name="editevalue" placeholder="enter your Material Type"  id="editevalue" required />
                            <input type="hidden" name="edit_material_id" id="edit_unit_id"  />
                        </div>
                        <div>
                            <select class="form-control" name="materialTypeCat" id="materialTypeCat">
                                <option value="">-</option>
                                <%
                                    getUnit getUnit1 = new getUnit();
                                    List<MaterialCategourt> list1 = getUnit1.getMaterialCat();
                                    for ( MaterialCategourt matCat : list1 ) {
                                        out.println("<option value='" + matCat.getMaterialCategouryDesc()+ "'>" + matCat.getMaterialCategouryDesc() + "</option>"); 
                                    }                        
                                %>
                            </select>
                        </div>
                            <div class="modal-footer">
                            <button type="submit" class="btn btn-default"  name="update" value="update">Update</button>
                        </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>

        <div class="col-lg-12">
            <div class="modal fade" id="formModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                            <h4 class="modal-title" id="H2">Material Type Form</h4>
                        </div>
                        <div class="modal-body">
                            <form role="form" action="materialtype" method="POST" onsubmit="return checkMaterialExistance('material_desc')">
                                <div class="form-group">
                                    <label>Material Type</label>
                                    <input clas="form-control" type="text" name="material_desc" list="existingMaterialTypes" placeholder="enter Material Type" required=""/>
                                   <datalist id="existingMaterialTypes">
                                        <%
                                                for (int i = 0; i < rr.size(); i++) {
                                        %>

                                        <option><%=rr.get(i).getItemTypeDesc() %></option>                                                

                                        <%
                                                }
                                        %>
                                    </datalist>
                                        
                                </div>
                                <div class="form-group">
                                    <label>Material Type Category</label>
                                    <select class="form-control" name="materialTypeCat2" id="materialTypeCat2">
                                        <option value="">-</option>
                                        <%
                                            for ( MaterialCategourt matCat : list1 ) {
                                                out.println("<option value='" + matCat.getMaterialCategouryDesc()+ "'>" + matCat.getMaterialCategouryDesc() + "</option>"); 
                                            }                        
                                        %>
                                    </select>
                                </div>
                                <div class="modal-footer">
                                    <button type="submit" name="save" value="save" class="btn btn-primary">Save changes</button>
                                </div>
                            </form>
                        </div>                            
                    </div>
                </div>
            </div>
        </div>

        <!--END MAIN WRAPPER -->

        <!-- FOOTER -->
        <div id="footer">
            <%@include  file="footer.jsp"%>        
        </div>
        <!--END FOOTER -->


        <!-- GLOBAL SCRIPTS -->
        <script src="assets/plugins/jquery-2.0.3.min.js"></script>
        <script src="assets/plugins/bootstrap/js/bootstrap.min.js"></script>
        <script src="assets/plugins/modernizr-2.6.2-respond-1.1.0.min.js"></script>
        <!-- END GLOBAL SCRIPTS -->

        <!-- PAGE LEVEL SCRIPTS -->
        <script src="assets/plugins/flot/jquery.flot.js"></script>
        <script src="assets/plugins/flot/jquery.flot.resize.js"></script>
        <script src="assets/plugins/flot/jquery.flot.time.js"></script>
        <script  src="assets/plugins/flot/jquery.flot.stack.js"></script>
        <script src="assets/js/for_index.js"></script>
        <script src="assets/plugins/jquery-2.0.3.min.js"></script>
        <script src="assets/plugins/bootstrap/js/bootstrap.min.js"></script>
        <script src="assets/plugins/modernizr-2.6.2-respond-1.1.0.min.js"></script>

        <!-- END PAGE LEVEL SCRIPTS -->

        <script src="assets/plugins/jquery-2.0.3.min.js"></script>
        <script src="assets/plugins/bootstrap/js/bootstrap.min.js"></script>
        <script src="assets/plugins/modernizr-2.6.2-respond-1.1.0.min.js"></script>
        <!-- END GLOBAL SCRIPTS -->
        <!-- PAGE LEVEL SCRIPTS -->
        <script src="assets/plugins/dataTables/jquery.dataTables.js"></script>
        <script src="assets/plugins/dataTables/dataTables.bootstrap.js"></script>
        
        <script src="https://code.jquery.com/jquery-1.12.3.js"></script>
        <script src="https://cdn.datatables.net/1.10.12/js/jquery.dataTables.min.js"></script>
        <script src="https://cdn.datatables.net/buttons/1.2.2/js/dataTables.buttons.min.js"></script>
        <script src="https://cdn.datatables.net/buttons/1.2.2/js/buttons.flash.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jszip/2.5.0/jszip.min.js"></script>
        <script src="https://cdn.rawgit.com/bpampuch/pdfmake/0.1.18/build/pdfmake.min.js"></script>
        <script src="https://cdn.rawgit.com/bpampuch/pdfmake/0.1.18/build/vfs_fonts.js"></script>
        <script src="https://cdn.datatables.net/buttons/1.2.2/js/buttons.html5.min.js"></script>
        <script src="https://cdn.datatables.net/buttons/1.2.2/js/buttons.print.min.js"></script>
        <script>
            $(document).ready(function () {
                $('#dataTables-example').DataTable( {
                    dom: 'Bfrtip',
                    buttons: [
                        'excel', 'pdf'
                    ]
                } );
                //$('#dataTables-example').dataTable();
            });
        </script>
    </body>

    <!-- END BODY -->
</html>
