grails.server.port.http = 8090
grails.servlet.version = "3.0" // Change depending on target container compliance (2.5 or 3.0)
grails.project.class.dir = "target/classes"
grails.project.test.class.dir = "target/test-classes"
grails.project.test.reports.dir = "target/test-reports"
grails.project.work.dir = "target/work"
grails.project.target.level = 1.6
grails.project.source.level = 1.6



grails.project.fork = [
        // configure settings for compilation JVM, note that if you alter the Groovy version forked compilation is required
        //  compile: [maxMemory: 256, minMemory: 64, debug: false, maxPerm: 256, daemon:true],

        // configure settings for the test-app JVM, uses the daemon by default
        test: [maxMemory: 768, minMemory: 64, debug: false, maxPerm: 256, daemon:true],
        // configure settings for the run-app JVM
        run: [maxMemory: 768, minMemory: 64, debug: false, maxPerm: 256, forkReserve:false],
        // configure settings for the run-war JVM
        war: [maxMemory: 768, minMemory: 64, debug: false, maxPerm: 256, forkReserve:false],
        // configure settings for the Console UI JVM
        console: [maxMemory: 768, minMemory: 64, debug: false, maxPerm: 256]
]

grails.project.dependency.resolver = "ivy" // or maven
grails.project.dependency.resolution = {
    // inherit Grails' default dependencies
    inherits("global") {
        // specify dependency exclusions here; for example, uncomment this to disable ehcache:
        //excludes 'ehcache'
    }
    log "error" // log level of Ivy resolver, either 'error', 'warn', 'info', 'debug' or 'verbose'
    checksums true // Whether to verify checksums on resolve
    legacyResolve true // whether to do a secondary resolve on plugin installation, not advised and here for backwards compatibility

    repositories {
        inherits true // Whether to inherit repository definitions from plugins
        grailsPlugins()
        grailsHome()
        grailsCentral()
        mavenLocal()
        mavenCentral()
        mavenRepo "http://repo.grails.org/grails/core"


    }

    dependencies {
        compile 'org.springframework:spring-core:3.2.8.RELEASE'
        compile 'org.springframework:spring-context:3.2.8.RELEASE'
        compile 'mysql:mysql-connector-java:5.1.27'
    }

    plugins {
        runtime ":jquery:1.11.0.2"
        runtime ":jasper:1.11.0"
        runtime ":excel-export:0.2.1"
        runtime ":database-migration:1.4.0"
        runtime ":resources:1.2.14"
        runtime ":cached-resources:1.1"

        build ":tomcat:7.0.52.1"
        //runtime ":hibernate:3.6.10.19"
        //compile ':cache:1.0.1'
		compile ":mail:1.0.7"
		compile ":bcrypt:1.0"
        compile ':cache-headers:1.1.6'
        //compile ":rest:0.8"
        //compile ":quartz2:2.1.6.2"
        //compile ":rest-client-builder:2.1.1"

    }
}