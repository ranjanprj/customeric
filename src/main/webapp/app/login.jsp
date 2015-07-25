<%@page import="java.util.Date"%>
<!DOCTYPE html>
<%@ include file="include.jsp" %>
<html lang="en">
    <head>
        <meta charset="utf-8">

        <style type="text/css">
            /* Override some defaults */
            html, body {
                background-color: white;
            }
            body {
                padding-top: 40px; /* 40px to make the container go all the way to the bottom of the topbar */
            }
            .container > footer p {
                text-align: center; /* center align it with the container */
            }
            .container {
                width: 90%; /* downsize our container to make the content feel a bit tighter and more cohesive. NOTE: this removes two full columns from the grid, meaning you only go to 14 columns and not 16. */

            }

            /* The white background content wrapper */
            .content {
                background-color: #fff;
                padding: 20px;
                margin: 0 -20px; /* negative indent the amount of the padding to maintain the grid system */
                -webkit-border-radius: 0 0 6px 6px;
                -moz-border-radius: 0 0 6px 6px;
                border-radius: 0 0 6px 6px;
                -webkit-box-shadow: 0 1px 2px rgba(0,0,0,.15);
                -moz-box-shadow: 0 1px 2px rgba(0,0,0,.15);
                box-shadow: 0 1px 2px rgba(0,0,0,.15);
                height: 600px;
            }

            /* Page header tweaks */
            .page-header {
                background-color: #f5f5f5;
                padding: 20px 20px 10px;
                margin: -20px -20px 20px;
            }

            /* Styles you shouldn't keep as they are for displaying this base example only */
            .content .span10,
            .content  {
                min-height: 500px;
            }
            /* Give a quick and non-cross-browser friendly divider */
            /*            .content .span4 {
                            margin-left: 0;
                            padding-left: 19px;
                            border-left: 1px solid #eee;
                        }*/

            .topbar .btn {
                border: 0;
            }

            
        </style>

      
    </head>

    <body>


        <form class="form-stacked"  name="loginform" action="" method="post">
                              
                            <fieldset>
                                <legend></legend>
                                <div class="clearfix">
                                    <label for="xlInput3">Username</label>
                                    <div class="input">
                                        <input type="text"  name="username" id="username" class="span4" placeholder="username" >
                                    </div>

                                </div><!-- /clearfix -->

                                <div class="clearfix">
                                    <label for="xlInput3">Password</label>
                                    <div class="input">
                                        <input type="password"  name="password" id="password" class="span4" placeholder="password" >
                                    </div>
                                </div><!-- /clearfix -->

                            </fieldset>
                            <button  style="float:right;margin-right: 40px;" class="btn primary" type="submit">Sign in</button>
                            
<!--                            <label>
                                <input type="checkbox"  name="rememberMe" id="rememberMe">
                                <span>Remember me</span>
                            </label>
                            -->
                            <label style="margin-top:20px;">
                                <a href="#">Problem accessing account ?</a>
                                
                            </label>
                            
                            

                        </form>

                        For Testing use admin/admin
                   
    </body>
</html>
