def isProd = grails.util.Environment.isWarDeployed()
def minPrefix = isProd ?'.min':''
def angularVer='1.3.15'

modules = {
    application {
        resource url:'js/application.js'
    }
}