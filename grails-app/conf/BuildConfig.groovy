grails.servlet.version = "3.0" // Change depending on target container compliance (2.5 or 3.0)
grails.project.class.dir = "target/classes"
grails.project.test.class.dir = "target/test-classes"
grails.project.test.reports.dir = "target/test-reports"
grails.project.work.dir = "target/work"
grails.project.target.level = 1.6
grails.project.source.level = 1.6
//grails.project.war.file = "target/${appName}-${appVersion}.war"

grails.project.fork = [
		// configure settings for compilation JVM, note that if you alter the Groovy version forked compilation is required
		//  compile: [maxMemory: 256, minMemory: 64, debug: false, maxPerm: 256, daemon:true],

		// configure settings for the test-app JVM, uses the daemon by default
		test: [maxMemory: 768, minMemory: 64, debug: false, maxPerm: 256, daemon: true],
		// configure settings for the run-app JVM
		run: [maxMemory: 768, minMemory: 64, debug: false, maxPerm: 256, forkReserve: false],
		// configure settings for the run-war JVM
		war: [maxMemory: 768, minMemory: 64, debug: false, maxPerm: 256, forkReserve: false],
		// configure settings for the Console UI JVM
		console: [maxMemory: 768, minMemory: 64, debug: false, maxPerm: 256]
]

grails.project.dependency.resolver = "maven" // or ivy
grails.project.dependency.resolution = {
	// inherit Grails' default dependencies
	inherits("global") {
		// specify dependency exclusions here; for example, uncomment this to disable ehcache:
		// excludes 'ehcache'
	}
	log "error" // log level of Ivy resolver, either 'error', 'warn', 'info', 'debug' or 'verbose'
	checksums true // Whether to verify checksums on resolve
	legacyResolve false // whether to do a secondary resolve on plugin installation, not advised and here for backwards compatibility

	repositories {
		inherits true // Whether to inherit repository definitions from plugins

		grailsPlugins()
		grailsHome()
		mavenLocal()
		grailsCentral()
		mavenCentral()
		// uncomment these (or add new ones) to enable remote dependency resolution from public Maven repositories
		//mavenRepo "http://repository.codehaus.org"
		//mavenRepo "http://download.java.net/maven/2/"
		//mavenRepo "http://repository.jboss.com/maven2/"
	}

	dependencies {
		// specify dependencies here under either 'build', 'compile', 'runtime', 'test' or 'provided' scopes e.g.
		// runtime 'mysql:mysql-connector-java:5.1.24'
		String springSecurityVersion = '3.1.4.RELEASE'
		String jacksonVersion = '2.2.3'

		compile "org.springframework.security:spring-security-core:$springSecurityVersion", {
			excludes 'aopalliance', 'aspectjrt', 'cglib-nodep', 'commons-collections', 'commons-logging',
					'ehcache', 'fest-assert', 'hsqldb', 'jcl-over-slf4j', 'jsr250-api', 'junit',
					'logback-classic', 'mockito-core', 'powermock-api-mockito', 'powermock-api-support',
					'powermock-core', 'powermock-module-junit4', 'powermock-module-junit4-common',
					'powermock-reflect', 'spring-aop', 'spring-beans', 'spring-context', 'spring-core',
					'spring-expression', 'spring-jdbc', 'spring-test', 'spring-tx'
		}

		compile "org.springframework.security:spring-security-web:$springSecurityVersion", {
			excludes 'aopalliance', 'commons-codec', 'commons-logging', 'fest-assert', 'groovy', 'hsqldb',
					'jcl-over-slf4j', 'junit', 'logback-classic', 'mockito-core', 'powermock-api-mockito',
					'powermock-api-support', 'powermock-core', 'powermock-module-junit4',
					'powermock-module-junit4-common', 'powermock-reflect', 'spock-core', 'spring-aop',
					'spring-beans', 'spring-context', 'spring-core', 'spring-expression', 'spring-jdbc',
					'spring-security-core', 'spring-test', 'spring-tx', 'spring-web', 'spring-webmvc',
					'tomcat-servlet-api'
		}

		compile "org.springframework.security:spring-security-config:$springSecurityVersion", {
			excludes 'aopalliance', 'commons-codec', 'commons-logging', 'fest-assert', 'groovy', 'hsqldb',
					'jcl-over-slf4j', 'junit', 'logback-classic', 'mockito-core', 'powermock-api-mockito',
					'powermock-api-support', 'powermock-core', 'powermock-module-junit4',
					'powermock-module-junit4-common', 'powermock-reflect', 'spock-core', 'spring-aop',
					'spring-beans', 'spring-context', 'spring-core', 'spring-expression', 'spring-jdbc',
					'spring-security-core', 'spring-test', 'spring-tx', 'spring-web', 'spring-webmvc',
					'tomcat-servlet-api'
		}

		compile "org.springframework.security.oauth:spring-security-oauth2:1.0.5.RELEASE", {
			transitive = false
			/*
			excludes 'aopalliance', 'commons-codec', 'commons-logging', 'fest-assert', 'groovy', 'hsqldb',
					'jcl-over-slf4j', 'junit', 'logback-classic', 'mockito-core', 'powermock-api-mockito',
					'powermock-api-support', 'powermock-core', 'powermock-module-junit4',
					'powermock-module-junit4-common', 'powermock-reflect', 'spock-core', 'spring-aop',
					'spring-beans', 'spring-context', 'spring-core', 'spring-expression', 'spring-jdbc',
					'spring-security-config', 'spring-security-core', 'spring-security-web',
					'spring-test', 'spring-tx', 'spring-web', 'spring-webmvc', 'tomcat-servlet-api'
					*/
		}

		compile 'org.codehaus.jackson:jackson-mapper-asl:1.9.13',
				'org.codehaus.jackson:jackson-core-asl:1.9.13'
	}

	plugins {
		// plugins for the build system only
		build ":tomcat:7.0.42"

		// plugins for the compile step
		compile ":scaffolding:2.0.1"
		compile ':cache:1.1.1'

		// plugins needed at runtime but not for compilation
		runtime ":hibernate:3.6.10.2" // or ":hibernate4:4.1.11.2"
		runtime ":database-migration:1.3.5"
		runtime ":jquery:1.10.2"
		runtime ":resources:1.2.1"
		// Uncomment these (or add new ones) to enable additional resources capabilities
		//runtime ":zipped-resources:1.0.1"
		//runtime ":cached-resources:1.1"
		//runtime ":yui-minify-resources:0.1.5"
	}
}
