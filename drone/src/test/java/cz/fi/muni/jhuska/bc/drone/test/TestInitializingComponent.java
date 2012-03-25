package cz.fi.muni.jhuska.bc.drone.test;

import static org.testng.Assert.assertNotNull;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.testng.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.testng.annotations.Test;

import cz.fi.muni.jhuska.bc.annotations.Component;
import cz.fi.muni.jhuska.bc.api.AbstractComponentMock;
import cz.fi.muni.jhuska.bc.drone.Enricher;

public class TestInitializingComponent extends Arquillian {

	@Component
	AbstractComponentMock abstractComponent;

	@Deployment(testable = false)
	public static WebArchive deploy() {
		return ShrinkWrap.create(WebArchive.class).addClass(Enricher.class);
	}

	@Test
	public void testComponentIsInitialized() {
		assertNotNull(abstractComponent,
				"AbstractComponent should be initialised at this point!");
	}

}
