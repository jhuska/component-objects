package cz.fi.muni.jhuska.bc.drone;

import org.jboss.arquillian.core.spi.LoadableExtension;
import org.jboss.arquillian.test.spi.TestEnricher;

public class ComponentModelExtension implements LoadableExtension {
	
	@Override
    public void register(ExtensionBuilder builder) {
        builder.service(TestEnricher.class, Enricher.class);
    }
}
