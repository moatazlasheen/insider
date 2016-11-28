﻿<!DOCTYPE html>
<!--[if IE 8]> <html lang="en" class="ie8"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9"> <![endif]-->
<!--[if !IE]><!--> <html lang="en"> <!--<![endif]-->

<!-- BEGIN HEAD -->
<head>
     <meta charset="UTF-8" />
    <title>BCORE Admin Dashboard Template | Calendar Page</title>
     <meta content="width=device-width, initial-scale=1.0" name="viewport" />
	<meta content="" name="description" />
	<meta content="" name="author" />
     <!--[if IE]>
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <![endif]-->
    <!-- GLOBAL STYLES -->
    <!-- GLOBAL STYLES -->
    <link rel="stylesheet" href="assets/plugins/bootstrap/css/bootstrap.css" />
    <link rel="stylesheet" href="assets/css/main.css" />
    <link rel="stylesheet" href="assets/css/theme.css" />
    <link rel="stylesheet" href="assets/css/MoneAdmin.css" />
    <link rel="stylesheet" href="assets/plugins/Font-Awesome/css/font-awesome.css" />
    <!--END GLOBAL STYLES -->

    <!-- PAGE LEVEL STYLES -->

       <link rel="stylesheet" href="assets/plugins/fullcalendar-1.6.2/fullcalendar/fullcalendar.css" />
<link rel="stylesheet" href="assets/css/calendar.css" />
    <!-- END PAGE LEVEL  STYLES -->
       <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
</head>
    <!-- END HEAD -->

    <!-- BEGIN BODY -->
<body class="padTop53 " >

   <!-- MAIN WRAPPER -->
    <div id="wrap">


         <!-- HEADER SECTION -->
        <div id="top">

            <nav class="navbar navbar-inverse navbar-fixed-top " style="padding-top: 10px;">
                <a data-original-title="Show/Hide Menu" data-placement="bottom" data-tooltip="tooltip" class="accordion-toggle btn btn-primary btn-sm visible-xs" data-toggle="collapse" href="#menu" id="menu-toggle">
                    <i class="icon-align-justify"></i>
                </a>
                <!-- LOGO SECTION -->
                <header class="navbar-header">

                    <a href="index.jsp" class="navbar-brand">
                    <img src="assets/img/logo.png" alt="" /></a>
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
                                <a href="#">
                                    <div>
                                       <strong>John Smith</strong>
                                        <span class="pull-right text-muted">
                                            <em>Today</em>
                                        </span>
                                    </div>
                                    <div>Lorem ipsum dolor sit amet, consectetur adipiscing.
                                        <br />
                                        <span class="label label-primary">Important</span> 

                                    </div>
                                </a>
                            </li>
                            <li class="divider"></li>
                            <li>
                                <a href="#">
                                    <div>
                                        <strong>Raphel Jonson</strong>
                                        <span class="pull-right text-muted">
                                            <em>Yesterday</em>
                                        </span>
                                    </div>
                                    <div>Lorem ipsum dolor sit amet, consectetur adipiscing.
                                         <br />
                                        <span class="label label-success"> Moderate </span> 
                                    </div>
                                </a>
                            </li>
                            <li class="divider"></li>
                            <li>
                                <a href="#">
                                    <div>
                                        <strong>Chi Ley Suk</strong>
                                        <span class="pull-right text-muted">
                                            <em>26 Jan 2014</em>
                                        </span>
                                    </div>
                                    <div>Lorem ipsum dolor sit amet, consectetur adipiscing.
                                         <br />
                                        <span class="label label-danger"> Low </span> 
                                    </div>
                                </a>
                            </li>
                            <li class="divider"></li>
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
                                <a href="#">
                                    <div>
                                        <p>
                                            <strong> Profile </strong>
                                            <span class="pull-right text-muted">40% Complete</span>
                                        </p>
                                        <div class="progress progress-striped active">
                                            <div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="40" aria-valuemin="0" aria-valuemax="100" style="width: 40%">
                                                <span class="sr-only">40% Complete (success)</span>
                                            </div>
                                        </div>
                                    </div>
                                </a>
                            </li>
                            <li class="divider"></li>
                            <li>
                                <a href="#">
                                    <div>
                                        <p>
                                            <strong> Pending Tasks </strong>
                                            <span class="pull-right text-muted">20% Complete</span>
                                        </p>
                                        <div class="progress progress-striped active">
                                            <div class="progress-bar progress-bar-info" role="progressbar" aria-valuenow="20" aria-valuemin="0" aria-valuemax="100" style="width: 20%">
                                                <span class="sr-only">20% Complete</span>
                                            </div>
                                        </div>
                                    </div>
                                </a>
                            </li>
                            <li class="divider"></li>
                            <li>
                                <a href="#">
                                    <div>
                                        <p>
                                            <strong> Work Completed </strong>
                                            <span class="pull-right text-muted">60% Complete</span>
                                        </p>
                                        <div class="progress progress-striped active">
                                            <div class="progress-bar progress-bar-warning" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 60%">
                                                <span class="sr-only">60% Complete (warning)</span>
                                            </div>
                                        </div>
                                    </div>
                                </a>
                            </li>
                            <li class="divider"></li>
                            <li>
                                <a href="#">
                                    <div>
                                        <p>
                                            <strong> Summary </strong>
                                            <span class="pull-right text-muted">80% Complete</span>
                                        </p>
                                        <div class="progress progress-striped active">
                                            <div class="progress-bar progress-bar-danger" role="progressbar" aria-valuenow="80" aria-valuemin="0" aria-valuemax="100" style="width: 80%">
                                                <span class="sr-only">80% Complete (danger)</span>
                                            </div>
                                        </div>
                                    </div>
                                </a>
                            </li>
                            <li class="divider"></li>
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
                                        <i class="icon-comment" ></i> New Comment
                                    <span class="pull-right text-muted small"> 4 minutes ago</span>
                                    </div>
                                </a>
                            </li>
                            <li class="divider"></li>
                            <li>
                                <a href="#">
                                    <div>
                                        <i class="icon-twitter info"></i> 3 New Follower
                                    <span class="pull-right text-muted small"> 9 minutes ago</span>
                                    </div>
                                </a>
                            </li>
                            <li class="divider"></li>
                            <li>
                                <a href="#">
                                    <div>
                                        <i class="icon-envelope"></i> Message Sent
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



        <!-- MENU SECTION -->
       <div id="left">
            <div class="media user-media well-small">
                <a class="user-link" href="#">
                    <img class="media-object img-thumbnail user-img" alt="User Picture" src="assets/img/user.gif" />
                </a>
                <br />
                <div class="media-body">
                    <h5 class="media-heading"> Joe Romlin</h5>
                    <ul class="list-unstyled user-info">
                        
                        <li>
                             <a class="btn btn-success btn-xs btn-circle" style="width: 10px;height: 12px;"></a> Online
                           
                        </li>
                       
                    </ul>
                </div>
                <br />
            </div>

            <ul id="menu" class="collapse">

                
                <li class="panel">
                    <a href="index.jsp" >
                        <i class="icon-table"></i> Dashboard
	   
                       
                    </a>                   
                </li>



                <li class="panel ">
                    <a href="#" data-parent="#menu" data-toggle="collapse" class="accordion-toggle" data-target="#component-nav">
                        <i class="icon-tasks"> </i> UI Elements     
	   
                        <span class="pull-right">
                          <i class="icon-angle-left"></i>
                        </span>
                       &nbsp; <span class="label label-default">10</span>&nbsp;
                    </a>
                    <ul class="collapse" id="component-nav">
                       
                        <li class=""><a href="button.jsp"><i class="icon-angle-right"></i> Buttons </a></li>
                         <li class=""><a href="icon.jsp"><i class="icon-angle-right"></i> Icons </a></li>
                        <li class=""><a href="progress.jsp"><i class="icon-angle-right"></i> Progress </a></li>
                        <li class=""><a href="tabs_panels.jsp"><i class="icon-angle-right"></i> Tabs & Panels </a></li>
                        <li class=""><a href="notifications.jsp"><i class="icon-angle-right"></i> Notification </a></li>
                         <li class=""><a href="more_notifications.jsp"><i class="icon-angle-right"></i> More Notification </a></li>
                        <li class=""><a href="modals.jsp"><i class="icon-angle-right"></i> Modals </a></li>
                          <li class=""><a href="wizard.jsp"><i class="icon-angle-right"></i> Wizard </a></li>
                         <li class=""><a href="sliders.jsp"><i class="icon-angle-right"></i> Sliders </a></li>
                        <li class=""><a href="typography.jsp"><i class="icon-angle-right"></i> Typography </a></li>
                    </ul>
                </li>
                <li class="panel ">
                    <a href="#" data-parent="#menu" data-toggle="collapse" class="accordion-toggle collapsed" data-target="#form-nav">
                        <i class="icon-pencil"></i> Forms
	   
                        <span class="pull-right">
                            <i class="icon-angle-left"></i>
                        </span>
                          &nbsp; <span class="label label-success">5</span>&nbsp;
                    </a>
                    <ul class="collapse" id="form-nav">
                        <li class=""><a href="forms_general.jsp"><i class="icon-angle-right"></i> General </a></li>
                        <li class=""><a href="forms_advance.jsp"><i class="icon-angle-right"></i> Advance </a></li>
                        <li class=""><a href="forms_validation.jsp"><i class="icon-angle-right"></i> Validation </a></li>
                        <li class=""><a href="forms_fileupload.jsp"><i class="icon-angle-right"></i> FileUpload </a></li>
                        <li class=""><a href="forms_editors.jsp"><i class="icon-angle-right"></i> WYSIWYG / Editor </a></li>
                    </ul>
                </li>

                <li class="panel active">
                    <a href="#" data-parent="#menu" data-toggle="collapse" class="accordion-toggle" data-target="#pagesr-nav">
                        <i class="icon-table"></i> Pages
	   
                        <span class="pull-right">
                            <i class="icon-angle-left"></i>
                        </span>
                          &nbsp; <span class="label label-info">6</span>&nbsp;
                    </a>
                    <ul class="in" id="pagesr-nav">
                        <li><a href="pages_calendar.jsp"><i class="icon-angle-right"></i> Calendar </a></li>
                        <li><a href="pages_timeline.jsp"><i class="icon-angle-right"></i> Timeline </a></li>
                        <li><a href="pages_social.jsp"><i class="icon-angle-right"></i> Social </a></li>
                        <li><a href="pages_pricing.jsp"><i class="icon-angle-right"></i> Pricing </a></li>
                        <li><a href="pages_offline.jsp"><i class="icon-angle-right"></i> Offline </a></li>
                        <li><a href="pages_uc.jsp"><i class="icon-angle-right"></i> Under Construction </a></li>
                    </ul>
                </li>
                <li class="panel">
                    <a href="#" data-parent="#menu" data-toggle="collapse" class="accordion-toggle" data-target="#chart-nav">
                        <i class="icon-bar-chart"></i> Charts
	   
                        <span class="pull-right">
                            <i class="icon-angle-left"></i>
                        </span>
                          &nbsp; <span class="label label-danger">4</span>&nbsp;
                    </a>
                    <ul class="collapse" id="chart-nav">



                        <li><a href="charts_line.jsp"><i class="icon-angle-right"></i> Line Charts </a></li>
                        <li><a href="charts_bar.jsp"><i class="icon-angle-right"></i> Bar Charts</a></li>
                        <li><a href="charts_pie.jsp"><i class="icon-angle-right"></i> Pie Charts </a></li>
                        <li><a href="charts_other.jsp"><i class="icon-angle-right"></i> other Charts </a></li>
                    </ul>
                </li>

                <li class="panel">
                    <a href="#" data-parent="#menu" data-toggle="collapse" class="accordion-toggle" data-target="#DDL-nav">
                        <i class=" icon-sitemap"></i> 3 Level Menu
	   
                        <span class="pull-right">
                            <i class="icon-angle-left"></i>
                        </span>
                    </a>
                    <ul class="collapse" id="DDL-nav">
                        <li>
                            <a href="#" data-parent="#DDL-nav" data-toggle="collapse" class="accordion-toggle" data-target="#DDL1-nav">
                                <i class="icon-sitemap"></i>&nbsp; Demo Link 1
	   
                        <span class="pull-right" style="margin-right: 20px;">
                            <i class="icon-angle-left"></i>
                        </span>


                            </a>
                            <ul class="collapse" id="DDL1-nav">
                                <li>
                                    <a href="#"><i class="icon-angle-right"></i> Demo Link 1 </a>

                                </li>
                                <li>
                                    <a href="#"><i class="icon-angle-right"></i> Demo Link 2 </a></li>
                                <li>
                                    <a href="#"><i class="icon-angle-right"></i> Demo Link 3 </a></li>

                            </ul>

                        </li>
                        <li><a href="#"><i class="icon-angle-right"></i> Demo Link 2 </a></li>
                        <li><a href="#"><i class="icon-angle-right"></i> Demo Link 3 </a></li>
                        <li><a href="#"><i class="icon-angle-right"></i> Demo Link 4 </a></li>
                    </ul>
                </li>
                <li class="panel">
                    <a href="#" data-parent="#menu" data-toggle="collapse" class="accordion-toggle" data-target="#DDL4-nav">
                        <i class=" icon-folder-open-alt"></i> 4 Level Menu
	   
                        <span class="pull-right">
                            <i class="icon-angle-left"></i>
                        </span>
                    </a>
                    <ul class="collapse" id="DDL4-nav">
                        <li>
                            <a href="#" data-parent="DDL4-nav" data-toggle="collapse" class="accordion-toggle" data-target="#DDL4_1-nav">
                                <i class="icon-sitemap"></i>&nbsp; Demo Link 1
	   
                        <span class="pull-right" style="margin-right: 20px;">
                            <i class="icon-angle-left"></i>
                        </span>


                            </a>
                            <ul class="collapse" id="DDL4_1-nav">
                                <li>

                                    <a href="#" data-parent="#DDL4_1-nav" data-toggle="collapse" class="accordion-toggle" data-target="#DDL4_2-nav">
                                        <i class="icon-sitemap"></i>&nbsp; Demo Link 1
	   
                        <span class="pull-right" style="margin-right: 20px;">
                            <i class="icon-angle-left"></i>
                        </span>
                                    </a>
                                    <ul class="collapse" id="DDL4_2-nav">



                                        <li><a href="#"><i class="icon-angle-right"></i> Demo Link 1 </a></li>
                                        <li><a href="#"><i class="icon-angle-right"></i> Demo Link 2 </a></li>
                                    </ul>



                                </li>
                                <li><a href="#"><i class="icon-angle-right"></i> Demo Link 2 </a></li>
                                <li><a href="#"><i class="icon-angle-right"></i> Demo Link 3 </a></li>
                            </ul>

                        </li>
                        <li><a href="#"><i class="icon-angle-right"></i> Demo Link 2 </a></li>
                        <li><a href="#"><i class="icon-angle-right"></i> Demo Link 3 </a></li>
                        <li><a href="#"><i class="icon-angle-right"></i> Demo Link 4 </a></li>
                    </ul>
                </li>
                <li class="panel">
                    <a href="#" data-parent="#menu" data-toggle="collapse" class="accordion-toggle" data-target="#error-nav">
                        <i class="icon-warning-sign"></i> Error Pages
	   
                        <span class="pull-right">
                            <i class="icon-angle-left"></i>
                        </span>
                          &nbsp; <span class="label label-warning">5</span>&nbsp;
                    </a>
                    <ul class="collapse" id="error-nav">
                        <li><a href="errors_403.jsp"><i class="icon-angle-right"></i> Error 403  </a></li>
                        <li><a href="errors_404.jsp"><i class="icon-angle-right"></i> Error 404  </a></li>
                        <li><a href="errors_405.jsp"><i class="icon-angle-right"></i> Error 405  </a></li>
                        <li><a href="errors_500.jsp"><i class="icon-angle-right"></i> Error 500  </a></li>
                        <li><a href="errors_503.jsp"><i class="icon-angle-right"></i> Error 503  </a></li>
                    </ul>
                </li>


                <li><a href="gallery.jsp"><i class="icon-film"></i> Image Gallery </a></li>
                <li><a href="tables.jsp"><i class="icon-table"></i> Data Tables </a></li>
                <li><a href="maps.jsp"><i class="icon-map-marker"></i> Maps </a></li>

                <li><a href="grid.jsp"><i class="icon-columns"></i> Grid </a></li>
                <li class="panel">
                    <a href="#" data-parent="#menu" data-toggle="collapse" class="accordion-toggle" data-target="#blank-nav">
                        <i class="icon-check-empty"></i> Blank Pages
	   
                        <span class="pull-right">
                            <i class="icon-angle-left"></i>
                        </span>
                         &nbsp; <span class="label label-success">2</span>&nbsp;
                    </a>
                    <ul class="collapse" id="blank-nav">
                       
                        <li><a href="blank.jsp"><i class="icon-angle-right"></i> Blank Page One  </a></li>
                        <li><a href="blank2.jsp"><i class="icon-angle-right"></i> Blank Page Two  </a></li>
                    </ul>
                </li>
                <li><a href="login.jsp"><i class="icon-signin"></i> Login Page </a></li>

            </ul>

        </div>
        <!--END MENU SECTION -->


        <!--PAGE CONTENT -->
        <div id="content">

            <div class="inner">
                <div class="row">
                    <div class="col-lg-12">


                        <h2> Full Calendar </h2>



                    </div>
                </div>

                <hr />
                  <div class="row">
                    <div class="col-lg-12">

                <div class="box">
  <header>
      <h5>Calendar</h5>
  </header>
  <div class="body">
      <div class="row">
	  <div class="col-lg-3">
	      <div class="well well-small">
		  <div id="add-event-form">
		      <fieldset>
			  <legend>Add Custom Event</legend>
			  <span class="help-block">Event Title</span>
			  <input id="title" name="title" type="text" placeholder="event title" class="form-control input-small">
			  <label class="radio">
			      <input type="radio" name="priority" value="label label-default" checked>
			      <span class="label label-default">default</span>
			  </label>
			  <label class="radio">
			      <input type="radio" name="priority" value="label label-warning">
			      <span class="label label-warning">warning</span>
			  </label>
			  <label class="radio">
			      <input type="radio" name="priority" value="label label-success">
			      <span class="label label-success">success</span>
			  </label>
			  <label class="radio">
			      <input type="radio" name="priority" value="label label-info">
			      <span class="label label-info">info</span>
			  </label>
			  <label class="radio">
			      <input type="radio" name="priority" value="label label-danger">
			      <span class="label label-danger">danger</span>
			  </label>
			  <br>
			  <button id="add-event" type="button" class="btn btn-sm btn-default">Add Event</button>
		      </fieldset>
		  </div>

	      </div>
	      <div class="well well-small">
		  <h4>Draggable Events</h4>
		  <ul id='external-events' class="list-inline">
		      <li class="external-event"><span class="label label-default">My Event 1</span></li>
		      <li class="external-event"><span class="label label-danger">My Event 2</span></li>
		      <li class="external-event"><span class="label label-success">My Event 3</span></li>
		      <li class="external-event"><span class="label label-warning">My Event 4</span></li>
		      <li class="external-event"><span class="label label-info">My Event 5</span></li>
		  </ul>

		  <label class="checkbox inline" for='drop-remove'>
		      <input type="checkbox" id="drop-remove">
		      remove after drop
		  </label>
	      </div>
	  </div>
	  <div id="calendar" class="col-lg-9"></div>
      </div>
  </div>


            </div>

</div>
                      </div>
                </div>


        </div>
         <!--PAGE CONTENT -->
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
    <script src="assets/js/jquery-ui.min.js"></script>

     <script src="assets/plugins/fullcalendar-1.6.2/fullcalendar/fullcalendar.min.js"></script>  
   <script src="assets/js/calendarInit.js"></script>
        <script>
            $(function () { CalendarInit(); });
        </script>
     <!--END PAGE LEVEL SCRIPTS -->

</body>
    <!-- END BODY -->
</html>
