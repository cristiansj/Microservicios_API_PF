package co.edu.uniquindio.Microservicios_API_PF.configuracion;

import jakarta.annotation.sql.DataSourceDefinition;
import jakarta.inject.Singleton;
import org.eclipse.microprofile.health.Startup;

import java.io.Serializable;

@DataSourceDefinition(

        name="java:app/seguridad/db",
        className = "com.mysql.cj.jdbc.MysqlDataSource",
        url = "${ENV=url}",//
        user = "${ENV=user}", //
        password = "${ENV=password}", //
        initialPoolSize = 2,
        minPoolSize = 2,
        maxPoolSize = 10,
        properties = {
                "useSSL=false",
                "useInformationSchema=true",
                "nullCatalogMeansCurrent=true",
                "nullNamePatternMatchesAll=false"
        }
)
@Singleton
@Startup
public class Persistencia {
}
