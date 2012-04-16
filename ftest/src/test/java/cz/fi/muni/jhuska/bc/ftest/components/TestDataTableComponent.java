package cz.fi.muni.jhuska.bc.ftest.components;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

import cz.fi.muni.jhuska.bc.ftest.AbstractTest;
import cz.fi.muni.jhuska.bc.ftest.components.bean.PersonBean;
import cz.fi.muni.jhuska.bc.impl.CalendarPopupComponentImpl;
import cz.fi.muni.jhuska.bc.impl.DataTable6ColTypesImpl;

public class TestDataTableComponent extends AbstractTest {

	@FindBy
	private DataTable6ColTypesImpl<String, String, Integer, String, String, CalendarPopupComponentImpl> table;

	@Deployment(testable = false)
	public static WebArchive deploy() {
		return createDeployment(TestDataTableComponent.class).addClass(
				PersonBean.class);
	}

	@Test
	public void testFoo() {
	}
}
