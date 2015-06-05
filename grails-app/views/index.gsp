<!DOCTYPE html>
<html>
<head>
    <title>GMS</title>
    <link href="images/mwp-logo.png" rel="shortcut icon">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" href="${resource(dir: 'css', file: 'gms.css')}" />
    <link rel="stylesheet" type="text/css" href="${resource(dir: 'css', file: 'bootstrap.css')}" />
</head>

<body>

    <div>
        <div>
            <div class="col-md-3 col-md-offset-4">

                <div class="login-panel panel panel-primary">
                    <div class="panel-heading">
                        <h3 class="panel-title"><g:message code="agency.login.title" default="Please Sign In" /></h3>
                    </div>
                    <div class="panel-body">
                        <g:if test="${result && result.errorMessage}">
                            <div style="text-align: center;color: red;font-size: 16px;padding-bottom: 10px;">${result.errorMessage}</div>
                        </g:if>
                        <g:form name="loginForm" url="./login">
                            <fieldset>
                                <div class="form-group">
                                    <input autocomplete="off" class="form-control login-field" placeholder="Username" name="loginName" type="text" autofocus>

                                </div>
                                <div class="form-group">
                                    <input autocomplete="off" class="form-control" placeholder="Password" name="password" type="password" value="">
                                </div>
                                <g:submitButton name="update" class="btn btn-lg btn-success btn-block" value="Login" />
                            </fieldset>
                        </g:form>
                    </div>
                </div>
            </div>
        </div>
    </div>

</body>
</html>
