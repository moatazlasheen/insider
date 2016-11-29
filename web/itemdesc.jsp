<%@page import="dto.ItemDescriptionTypeWrapper"%>
<%@page import="jpa.ItemDescriptionTypeJpaController"%>
<%@page import="entity.Units"%>
<%@page import="jpa.UnitsJpaController"%>
<%@page import="entity.Gener"%>
<%@page import="entity.ItemDescription"%>
<%@page import="jpa.ItemDescriptionJpaController"%>
<%@page import="jpa.MaterialTypeJpaController"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entity.MaterialType"%>
<%@page import="java.util.List"%>
<%@page import="javax.persistence.EntityManagerFactory"%>
<%@page import="javax.persistence.Persistence"%>
<%@page import="model.cons"%>
<!DOCTYPE html>
<!--[if IE 8]> <html lang="en" class="ie8"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9"> <![endif]-->
<!--[if !IE]><!--> <html lang="en"> <!--<![endif]-->
    <!-- BEGIN HEAD -->
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <head>
        <meta charset="UTF-8" />
        <title>INSIDER 360</title>
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
        <!-- END PAGE LEVEL  STYLES -->
        <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
          <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
        <![endif]-->
        <SCRIPT language="javascript">
            function Add() {

                $("#dataTables tbody").append(
                        " <tr>" +
                        "<td> <input  type = \"text\" name = \"typeDesc[]\" class = \"form-control\"  readonly= 'true' /> </td>" +
                        "<td> <input type = \"text\" name = \"typeCat[]\"  class = \"form-control\" /> </td>" +
                        "<td> <input type = \"text\" name = \"typeCode[]\"  class = \"form-control\" /> </td> " +
                        "<td> <input type = \"text\" name = \"typeCode[]\"  class = \"form-control\" /> </td> " +
                        "<td> <input type = \"text\" name = \"typeCode[]\"  class = \"form-control\" /> </td> " +
                        "<td> <input type = \"text\" name = \"typeCode[]\"  class = \"form-control\" /> </td> " +
                        "</tr>");

            }

            function save() {



            }
        </script>
        <style>
            table td {
                text-align: center;
                vertical-align: middle;
                padding: 5px;
                position: relative;
            }
        </style>

    </head>

    <!-- END HEAD -->

    <!-- BEGIN BODY -->
    <body class="padTop53 " >
        <% EntityManagerFactory emf = Persistence.createEntityManagerFactory(cons.entityName);
            MaterialTypeJpaController materialTypeConroller = new MaterialTypeJpaController(emf);
            jpa.GenerJpaController generJpaController = new jpa.GenerJpaController(emf);
            ItemDescriptionJpaController itemDescriptionJpaController = new ItemDescriptionJpaController(emf);
            UnitsJpaController unitsJpaController = new UnitsJpaController(emf);
            ItemDescriptionTypeJpaController itemDescriptionTypeJpaController = new ItemDescriptionTypeJpaController(emf);
        %>

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
                                <h5>Item Description</h5>
                            </div>
                        </div>
                        <hr />


                        <div class="row">
                            <div class="col-lg-12">
                                <div class="panel panel-default">
                                    <div class="panel-heading">
                                        Item Description
                                    </div>
                                    <div class="panel-body">
                                        <div class="table-responsive">
                                            <table class="table table-striped table-bordered table-hover" id="dataTables">
                                                <thead align="center">
                                                    <tr align="center">
                                                        <!--<th>Type ID</th>-->
                                                        <th >ID</th>
                                                        <th >Code</th>
                                                        <th >Description</th>
                                                        <th >Item_Type</th>
                                                        <th >Unit ID</th>
                                                        <th class="col-lg-2">Upload</th>
                                                        <th >Genre</th>
                                                        <th >Operations</th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                <%
                                                    ArrayList<ItemDescription> items = new ArrayList<ItemDescription>(itemDescriptionJpaController.findItemDescriptionEntities());
                                                    
                                                    for (ItemDescription item : items) {
                                                %>

                                                <tr align="center">
                                                    <!--<td><label>1</label></td>-->
                                                    <td align="center" id="id" class="col-lg-1"><% out.print(item.getItemId());%></td>
                                                    <td valign="middle" class="col-lg-1"><% out.print(item.getItemCode());%></td>
                                                    <td valign="middle" class="col-lg-2"><% out.print(item.getItemDesc());%></td>
                                                    <td valign="middle" class="col-lg-2"><% out.print(item.getItemTypeId());%></td>
                                                    <td valign="middle" class="col-lg-1"><% out.print(unitsJpaController.findUnits(item.getUnitId()).getUnitDesc());%></td>
                                                    <td valign="middle" class="col-sm-2"><% out.print(item.getUploadFileName());%></td>
                                                    <td valign="middle" class="col-lg-2"><% out.print(generJpaController.findGener(item.getGenerId()).getGenerDesc());%></td>
                                                    <td style='white-space: nowrap' class="col-lg-2">
                                                        <a class = "btn btn-warning" href="#?editId=<%=item.getItemCode()%>" id="editItemDescription" onclick="editItemDescriptionRecord(this)">Edit</a>
                                                        <a class = "btn btn-danger" href="#?deleteId=<%=item.getItemCode()%>" id="deleteItemDescription" onclick="deleteItemDescriptionRecord(this)">Delete</a>
                                                    </td>

                                                </tr>

                                                <%
                                                    }
                                                %>
                                            <form method="POST" action="itemdescription"  enctype="multipart/form-data">


                                                <tr align="center">
                                                    <!--<td><label>1</label></td>-->
                                                    <td align="center"></td>
                                                    <td align="center"><input type="text" name="code"  class="form-control" /></td>
                                                    <td align="center">
                                                        <input list="description" name="description" type="text" required="true">
                                                        <datalist id="description">
                                                            <%
                                                                for (ItemDescription item : items) {
                                                            %>
                                                            <option value="<% out.print(item.getItemDesc());%>"></option>

                                                            <% }%>
                                                        </datalist>
                                                        <!--<input type="text" name="description"  class="form-control" required="true"/>-->

                                                    </td>
                                                    <td align="center">
                                                        <!--<input type="text" name="item_type"  class="form-control" required="true"/>-->
                                                        <input list="item_type" name="item_type" type="text" required="true" class="col-sm-2">
                                                        <datalist id="item_type">
                                                    <% 
//                                                       ItemDescription item = items.get(0);
                                                       for(ItemDescriptionTypeWrapper wrapper :itemDescriptionTypeJpaController.getAllData()){
                                                           %>                                                    
                                                        <option value="<% out.print(wrapper.getId());%>"><% out.print(wrapper.getDescription());%></option>
                                                            <% }%>
                                                        </datalist>
                                                    </td>
                                                    <td align="center">
                                                        <!--                                                        <input type="text" name="unit_id"  class="form-control" required="true"/>-->
                                                        <input list="units_list" name="unit_id" type="text" required="true">

                                                        <datalist id="units_list">
                                                            <%
                                                                for (Units unit : unitsJpaController.findUnitsEntities()) {

                                                            %>

                                                            <option value="<% out.print(unit.getUnitId());%>"><% out.print(unit.getUnitDesc());%></option>

                                                            <%
                                                                }
                                                            %>

                                                        </datalist>
                                                    </td>
                                                    <td align="center"><input type="file" name="fileTOBeUploaded" required="true" class="col-sm-2"/></td>
                                                        <%
                                                            try {

                                                                List<Gener> geners = generJpaController.findGenerEntities();
                                                        %>
                                                    <td ><select name="gener_id" id="gener_id">
                                                            <%
                                                                for (Gener gener : geners) {
                                                            %>
                                                            <option value="<% out.print(gener.getGenerId());%>"><% out.print(gener.getGenerDesc());%></option>
                                                            <%
                                                                    }
                                                                } catch (Exception e) {
                                                                    e.printStackTrace();
                                                                }
                                                            %>

                                                        </select>
                                                    </td> 

                                                </tr>

                                                </tbody>

                                        </table>
                                        <input type="hidden" name="fileUploadForm" value="true"/>
                                        <input class="btn btn-primary" type="submit" name="submit" value="Save" /><!-- onclick="save()" -->
                                        <input class="btn btn-danger" type="reset" name="submit" value="Reset"/>

                                        </form>
                                    </div>
                                </div>
                                                            <input type="hidden" value="operation" name="operation" id="operation"/>
                                <input type="hidden" value="operationId" name="operationId" id="operationId"/>
                            </div>
                        </div>
                    </div>

                </div>

            </div>
            <!--END PAGE CONTENT -->

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
        <script src="assets/plugins/dataTables/jquery.dataTables.js"></script>
        <script src="assets/plugins/dataTables/dataTables.bootstrap.js"></script>
        <script>
            $(document).ready(function () {
                $('#dataTables-example').dataTable();
            });
            function editItemDescriptionRecord(editButton) {
                var $row = $(editButton).closest("tr");  
                var $text = $row.find("#id").text(); // Find the text

                // Let's test it out
//                alert($text);
                var operationId = $text;
                var operation= "edit";
                $("#operationId").val($text);
                $("#operation").val("edit");
                //---------------Start the ajax request ---------------------------
//                $.ajax({
//                    url: "itemdescription",
//                    type: "get", //send it through get method
//                    data:{operation:operation,operationId:operationId},
//                    success: function(response) {
//                      //Do Something
//                    },
//                    error: function(xhr) {
//                      //Do Something to handle error
//                    }
//                  });
            }
            //-------------------------------------------------------------------
            // This method repsonsible for deleting a record
            //-------------------------------------------------------------------
            
            function deleteItemDescriptionRecord(deleteButton) {
                if (confirm("Do you really want to delete this record? ") == true) {
//                    x = "You pressed OK!";
                    var $row = $(deleteButton).closest("tr");  
                    var $text = $row.find("#id").text(); // Find the text

                    // Let's test it out
    //                alert($text);
                    var operationId = $text;
                    var operation= "delete";
                    $("#operationId").val($text);
                    $("#operation").val("edit");
                    //---------------Start the ajax request ---------------------------
                    $.ajax({
                        url: "itemdescription",
                        type: "get", //send it through get method
                        data:{operation:operation,operationId:operationId},
                        success: function(response) {
                          //Do Something
                          alert(response.message);
                          $row.remove();
                        },
                        error: function(xhr) {
                          //Do Something to handle error
                          alert('couldn\'t delete item description');
                        }
                      });
                } else {
//                    x = "You pressed Cancel!";
                }
                
            }
        </script>

    </body>

    <!-- END BODY -->
</html>
