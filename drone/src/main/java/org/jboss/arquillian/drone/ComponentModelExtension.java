package org.jboss.arquillian.drone;

import org.jboss.arquillian.core.spi.LoadableExtension;
import org.jboss.arquillian.drone.impl.ComponentModelDroneConfigurator;
import org.jboss.arquillian.drone.impl.ComponentModelWebDriverSupport;

public class ComponentModelExtension implements LoadableExtension {
	
	@Override
    public void register(ExtensionBuilder builder) {
        builder.observer(ComponentModelDroneConfigurator.class);
        builder.observer(ComponentModelWebDriverSupport.class);
    }
}
