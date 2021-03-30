package Prueba;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class PruebaDavidApplication extends Application<PruebaDavidConfiguration> {

    public static void main(final String[] args) throws Exception {
        new PruebaDavidApplication().run(args);
    }

    public String getName() {
        return "PruebaDavid";
    }

    public void initialize(final Bootstrap<PruebaDavidConfiguration> bootstrap) {
        // TODO: application initialization
    }

    public void run(final PruebaDavidConfiguration configuration,
                    final Environment environment) {
        final PruebaResource resource = new PruebaResource(
        configuration.getTemplate(),
        configuration.getDefaultName()
		);
		final TemplateHealthCheck healthCheck =
			new TemplateHealthCheck(configuration.getTemplate());
		environment.healthChecks().register("template", healthCheck);
		environment.jersey().register(resource);
		}

}
