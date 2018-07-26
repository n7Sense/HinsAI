<%--
  Created by IntelliJ IDEA.
  User: nSense
  Date: 28-May-18
  Time: 12:17 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <title>Welcome to Grails</title>
    <style type="text/css" media="screen">
        #status {
            background-color: #eee;
            border: .2em solid #fff;
            margin: 2em 2em 1em;
            padding: 1em;
            width: 12em;
            float: left;
            -moz-box-shadow: 0px 0px 1.25em #ccc;
            -webkit-box-shadow: 0px 0px 1.25em #ccc;
            box-shadow: 0px 0px 1.25em #ccc;
            -moz-border-radius: 0.6em;
            -webkit-border-radius: 0.6em;
            border-radius: 0.6em;
        }

        .ie6 #status {
            display: inline;
        }

        #status ul {
            font-size: 0.9em;
            list-style-type: none;
            margin-bottom: 0.6em;
            padding: 0;
        }

        #status li {
            line-height: 1.3;
        }

        #status h1 {
            text-transform: uppercase;
            font-size: 1.1em;
            margin: 0 0 0.3em;
        }

        #page-body {
            margin: 2em 1em 1.25em 18em;
        }

        h2 {
            margin-top: 1em;
            margin-bottom: 0.3em;
            font-size: 1em;
        }

        p {
            line-height: 1.5;
            margin: 0.25em 0;
        }

        #controller-list ul {
            list-style-position: inside;
        }

        #controller-list li {
            line-height: 1.3;
            list-style-position: inside;
            margin: 0.25em 0;
        }

        @media screen and (max-width: 480px) {
            #status {
                display: none;
            }

            #page-body {
                margin: 0 1em 1em;
            }

            #page-body h1 {
                margin-top: 0;
            }
        }
    </style>

</head>
<body>
<div id="grailsLogo" role="banner"><a href="http://grails.org"><img src="/nSense/assets/grails_logo.png" alt="Grails"></a></div>

<a href="#page-body" class="skip">Skip to content…</a>
<div id="status" role="complementary">
    <h1>Application Status</h1>
    <ul>
        <li>App version: 0.1</li>
        <li>Grails version: 2.4.2</li>
        <li>Groovy version: 2.3.3</li>
        <li>JVM version: 1.7.0_80</li>
        <li>Reloading active: true</li>
        <li>Controllers: 3</li>
        <li>Domains: 1</li>
        <li>Services: 3</li>
        <li>Tag Libraries: 15</li>
    </ul>
    <h1>Installed Plugins</h1>
    <ul>

        <li>logging - 2.4.2</li>

        <li>core - 2.4.2</li>

        <li>restResponder - 2.4.2</li>

        <li>dataBinding - 2.4.2</li>

        <li>i18n - 2.4.2</li>

        <li>codecs - 2.4.2</li>

        <li>servlets - 2.4.2</li>

        <li>dataSource - 2.4.2</li>

        <li>urlMappings - 2.4.2</li>

        <li>webxml - 1.4.1</li>

        <li>assetPipeline - 1.8.11</li>

        <li>jquery - 1.11.1</li>

        <li>databaseMigration - 1.4.0</li>

        <li>controllers - 2.4.2</li>

        <li>filters - 2.4.2</li>

        <li>mimeTypes - 2.4.2</li>

        <li>groovyPages - 2.4.2</li>

        <li>scaffolding - 2.1.2</li>

        <li>controllersAsync - 2.4.2</li>

        <li>domainClass - 2.4.2</li>

        <li>hibernate4 - 4.3.5.4</li>

        <li>converters - 2.4.2</li>

        <li>services - 2.4.2</li>

        <li>validation - 2.4.2</li>

        <li>cache - 1.1.7</li>

    </ul>
</div>
<div id="page-body" role="main">
    <h1>Welcome to Grails</h1>
    <p>Congratulations, you have successfully started your first Grails application! At the moment
        this is the default page, feel free to modify it to either redirect to a controller or display whatever
        content you may choose. Below is a list of controllers that are currently deployed in this application,
        click on each to execute its default action:</p>

    <div id="controller-list" role="navigation">
        <h2>Available Controllers:</h2>
        <ul>

            <li class="controller"><a href="/employee/index">nSense.EmployeeController</a></li>

        </ul>
    </div>
</div>

<div class="footer" role="contentinfo"></div>
<div id="spinner" class="spinner" style="display:none;">Loading…</div>


</body></html>