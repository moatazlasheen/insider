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

        <!--                bootstrap select
                <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.12.1/css/bootstrap-select.min.css">-->


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
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.2.0/jquery.min.js"></script>

        <script>

            var elementsToJson = [];
            $(document).ready(function () {
                $("#jsonNotifier").hide();
            });
            function add() {
                var selectedCat = $("#cat option:selected");
                var selectedMaterial = $("#materials option:selected");
                $('#dataTables > tbody > tr:first').before('<tr><td>' + selectedCat.text() + '</td><td>' + selectedMaterial.text() + '</td></tr>');
                elementsToJson.push([selectedCat.val(), selectedMaterial.val()]);
            }

            function edit() {


            }
            function save() {

                var json = JSON.stringify(elementsToJson);
                $.ajax({
                    url: 'itemdescriptionajax',
                    data: {
                        elements: json
                    },
                    success: function (data) {
                        alert(data);
                        $("#jsonNotifier").show();
                    }
                });
                return false;
            }
            function deleteItem() {
                var selected = [];
                $('.items:checkbox:checked').each(function () {
                    selected.push($(this).val());
                    alert($(this).val());
                });
                $.post('itemdescriptionajax',
                        {
                            elements: selected
                        }, function (data) {
                    alert(data);

                }
                );
                return false;
            }

//            function getAllMaterialsByCat() {
//                $("#materials").empty().append("<option>materials</option>").prop("disabled", true);
//                var cat = $("#cat option:selected").val();
//
//                $.ajax({
//                    url: 'materialajax',
//                    data: {
//                        catID: cat
//                    },
//                    success: function (data) {
//                        var options = "";
//                        var json = JSON.parse(data);
//
//                        for (var i = 0; i < json.length; i++) {
//                            options += "<option value = '" + json[i].materialTypeId + "'>" + json[i].itemTypeDesc + " </option>";
//
//                        }
//
//                        
//                    }
//                });

//                return false;
//            }
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
                                            <form method="POST" action="#">
                                                <div id="jsonNotifier" class="alert alert-success alert-dismissible">
                                                    <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                                                    <strong>Success!</strong> Data is inserted
                                                </div>

                                                <table id="itemDescriptionTable" class="table table-striped table-bordered table-hover">
                                                    <thead>
                                                        <tr>
                                                            <th>Select</th>
                                                            <th>Item</th>
                                                        </tr>
                                                    </thead>

                                                <c:forEach var="item" items="${requestScope.itemsWrappers}">
                                                    <tr>
                                                        <td><input type="checkbox" value="${item.id}" class="items"></td>
                                                        <td>${item.description}</td></tr>
                                                    </c:forEach>
                                                <tbody>

                                            </table>

                                            <table class="table table-striped table-bordered table-hover" id="dataTables">
                                                <thead>
                                                    <tr>
                                                        <th>Category</th>
                                                        <th>Material</th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <tr id="lstTR">
                                                        <td><select id="cat">
                                                                <option>category</option>
                                                                <c:forEach var="cat" items="${requestScope.cats}">
                                                                    <option value="${cat.materailCategouryId}">${cat.materialCategouryDesc}</option>
                                                                </c:forEach>
                                                            </select></td> 

                                                        <td><select  id="materials">
                                                                <option>materials</option>
                                                                <c:forEach var="material" items="${requestScope.materials}">
                                                                    <option value="${material.materialTypeId}">${material.itemTypeDesc}</option>
                                                                </c:forEach>
                                                            </select></td> 


                                                    </tr>

                                                </tbody>

                                            </table>
                                            <input class="btn btn-primary" type="button" name="addBtn" value="add" onclick="add()"/> 
                                            <!--                                            <input class="btn btn-info" type="button" name="editBtn" value="edit" onclick="edit()"/> -->
                                            <input class="btn btn-success" type="button" name="saveBtn" value="save" onclick="save()"/>
                                            <input class="btn btn-danger" type="button" name="editBtn" value="delete" onclick="deleteItem()"/> 
                                        </form>
                                    </div>
                                </div>
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


        <!--         Latest compiled and minified JavaScript 
                <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.12.1/js/bootstrap-select.min.js"></script>
                 (Optional) Latest compiled and minified JavaScript translation files 
                <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.12.1/js/i18n/defaults-*.min.js"></script>-->


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
        </script>

    </body>

    <!-- END BODY -->
</html>
