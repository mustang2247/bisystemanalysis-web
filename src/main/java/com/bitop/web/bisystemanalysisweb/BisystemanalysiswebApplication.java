package com.bitop.web.bisystemanalysisweb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.beans.PropertyVetoException;
import java.sql.SQLException;

@SpringBootApplication
public class BisystemanalysiswebApplication {

	private static final Logger logger = LoggerFactory.getLogger( BisystemanalysiswebApplication.class );

	public static void main(String[] args) throws PropertyVetoException, SQLException {
//		if( args.length < 2 ) {
//			System.err.println( "USAGE: java -jar bisystemanalysisweb.jar -gateaddr domain:port" );
//			System.exit( -1 );
//		}

		SpringApplication.run(BisystemanalysiswebApplication.class, args);
		logger.info("Application is starting...........");

//		String envDir = PropUtil.getProp( "/env.properties", "envdir" );
//		logger.info("Application is getProp........... " + envDir);
//
//		RedisManager.getJedis();
//
//		boolean boo = RepoManager.init( "/" + envDir + "mysql.properties");
//
//		logger.info("init RepoManager..........." + boo);

	}
}
