dataSource {
    pooled = true
    driverClassName = "com.mysql.jdbc.Driver"
    dialect = "org.hibernate.dialect.MySQLDialect"
}
hibernate {
    cache.use_second_level_cache = true
    cache.use_query_cache = false
    cache.region.factory_class = 'net.sf.ehcache.hibernate.EhCacheRegionFactory'
}
// environment specific settings
environments {
    development {
        dataSource {
			dbCreate = "update"
			url = "jdbc:mysql://localhost:3306/gms?zeroDateTimeBehavior=convertToNull&useUnicode=yes&characterEncoding=UTF-8"
			username = "root"
			password = "root"

        }
    }
    test {
        dataSource {
            dbCreate = "update"
            url = "jdbc:h2:mem:testDb;MVCC=TRUE;LOCK_TIMEOUT=10000"
        }
    }
    production {
        dataSource {
			pooled = false
			dbCreate = "update"
			driverClassName = "com.mysql.jdbc.Driver"
			url = "jdbc:mysql://localhost:3306/gms?zeroDateTimeBehavior=convertToNull&useUnicode=yes&characterEncoding=UTF-8"
			username = "jarvis_jarvis"
			password = "bVZasQK3d9U@-B9*5w"
        }
    }
}
