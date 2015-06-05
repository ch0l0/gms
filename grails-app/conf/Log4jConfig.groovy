// Log4j Settings configuration...
import grails.util.Environment
import org.apache.log4j.ConsoleAppender
import org.apache.log4j.DailyRollingFileAppender
import org.apache.log4j.Level
import org.apache.log4j.PatternLayout

def log4jConsoleLogLevel = Level.INFO
def log4jAppFileLogLevel = Level.INFO

logPath = 'target/'


if (Environment.isWarDeployed()){
    grails.logging.jul.usebridge = false
} else{
    grails.logging.jul.usebridge = true
    log4jConsoleLogLevel = Level.DEBUG
    log4jAppFileLogLevel = Level.DEBUG
    logPath = 'target/'
}


def logFileName = logPath + 'gms3.log'

log4j = {
    def logLayoutPattern = new PatternLayout("%d{HH:mm:ss} %-5p %c - %m%n")


    appenders {
        appender new ConsoleAppender(name: "stdout",
                threshold: log4jConsoleLogLevel,
                encoding: "UTF-8",
                layout: logLayoutPattern
        )
        appender new DailyRollingFileAppender(name: "appFile",
                threshold: log4jAppFileLogLevel,
                file: logFileName,
                datePattern: "'.'yyyy-MM-dd",
                encoding: "UTF-8",
                layout: logLayoutPattern
        )
    }

    error  'org.codehaus.groovy.grails.web.servlet',        // controllers
            'org.codehaus.groovy.grails.web.pages',          // GSP
            'org.codehaus.groovy.grails.web.sitemesh',       // layouts
            'org.codehaus.groovy.grails.web.mapping.filter', // URL mapping
            'org.codehaus.groovy.grails.web.mapping',        // URL mapping
            'org.codehaus.groovy.grails.commons',            // core / classloading
            'org.codehaus.groovy.grails.plugins',            // plugins
            'org.codehaus.groovy.grails.orm.hibernate',      // hibernate integration
            'org.springframework',
            'org.hibernate',
            'net.sf.ehcache.hibernate',
            'com.opensymphony',
            'org.quartz',
            'org.infinispan',
            'org.jgroups',
            'org.apache',
            'com.sun'



    debug 'grails.app.controllers',
          'grails.app.services',
          'grails.app.filters'



    root {
        error 'stdout', 'appFile'
        additivity = true
    }
}