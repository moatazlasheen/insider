<%@page import="inquiry.getUnit"%>
<%@page import="entity.Gener"%>
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

           function ram() {
            $(".use-address").click(function () {
                var $row = $(this).closest("tr");    // Find the row
                var $text = $row.find(".descc").text(); // Find the text
                var $text1 = $row.find(".idd").text(); // Find the text
                var $text2=$row.find(".codee").text();
                // Let's test it out
                document.getElementById("editevalue").value=$text;
                document.getElementById("edit_gener_id").value=$text1;
                document.getElementById("edit_code").value=$text2;
            });
             
             }
             
               function ram2() {
            $(".use-address").click(function () {
                var $row = $(this).closest("tr");    // Find the row
                var $text1 = $row.find(".idd").text(); // Find the text

                // Let's test it out
                document.getElementById("id_value_del").value=$text1;
            });
             
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
                                <h5>Gener Setup</h5>
                            </div>
                        </div>
                        <hr />


                        <div class="row">
                            <div class="col-lg-12">
                                <div class="panel panel-default">
                                    <div class="panel-heading">
                                        Gener Setup
                                    </div>
                                    <div class="panel-body">
                                        <div class="table-responsive">

                                            <table class="table table-striped table-bordered table-hover" id="dataTables-example">                                                    <thead>
                                                    <tr>
                                                        <th style="display: none;">Type ID</th>
                                                        <th>gener code</th>
                                                        <th>gener Description</th>
                                                        <th>Action</th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <tr>
                                                        <!--<td><label>1</label></td>-->
                                                    <%

                                                        List<Gener> rr = new getUnit().getgener();
                                                        for (int i = 0; i < rr.size(); i++) {
                                                    %>
                                                    <td class="idd" style="display: none;"><%=rr.get(i).getGenerId() %> </td>
                                                    <td class="codee"><%=rr.get(i).getGenerCode()%></td>                                                
                                                    <td class="descc"><%=rr.get(i).getGenerDesc()%></td>                                                
                                                    <td>
                                                        <button type="button" class="btn btn-default btn-sm btn-grad btn-rect use-address" data-target="#buttonedModal2"  data-toggle="modal"  aria-hidden="true"  onclick="ram()">EDIT</button>
                                                        <button type="button" class="btn btn-danger btn-sm btn-grad btn-rect use-address" data-target="#buttonedModal"  data-toggle="modal"  aria-hidden="true" onclick="ram2()">DEL</button>

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
                            <h4 class="modal-title" id="H1">Del Gener</h4>
                        </div>
                        <div class="modal-body">
                            are you confirm to delete this record
                        </div>
                        <div class="modal-footer">
                            <form method="POST" action="gener">
                                <input type="hidden" name="id_value_del" id="id_value_del" />
                                <button type="submit" class="btn btn-primary" name="del_gener" value="delete">DELETE</button>
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
                            <h4 class="modal-title" id="H1">Edit Gener</h4>
                        </div>
                        <form role="form" method="POST" action="gener">
                        <div class="modal-body">
                            <input type="text" class="form-control" name="edit_code" placeholder="enter your gener code here"  id="edit_code" required="" autofocus=""/>
                            <input type="text" class="form-control" name="editevalue" placeholder="enter your gener here"  id="editevalue" required=""/>
                            <input type="hidden" name="edit_gener_id" id="edit_gener_id"  />
                        </div>
                        <div class="modal-footer">
                            <button type="submit" class="btn btn-default"  name="update_gener" value="update">Update</button>
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
                            <h4 class="modal-title" id="H2">Gener Form</h4>
                        </div>
                        <div class="modal-body">
                            <form role="form" action="gener" method="POST">
                                <div class="form-group">
                                    <!--<label>Gener Code</label>-->
                                    <input clas="form-control" type="text" name="gener_code" placeholder="enter gener code here" required=""/><br />
                                    <!--<label>Gener Description</label>-->
                                    <br />
                                    <input clas="form-control" type="text" name="gener_desc" placeholder="enter gener desc here" required=""/>
                                </div>                                      
                                <div class="modal-footer">
                                    <button type="submit" name="savegener" value="save" class="btn btn-primary">Save changes</button>
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
        <script>
            $(document).ready(function () {
                $('#dataTables-example').dataTable();
            });
        </script>
    </body>

    <!-- END BODY -->
</html>
