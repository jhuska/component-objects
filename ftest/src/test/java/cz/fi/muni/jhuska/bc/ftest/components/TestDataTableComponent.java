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
    
    @Inject
    private List<String> list;
    
    ListOfStrings extends LinkedList<String>;

//    (Table) list.get(0)
    
    list.add((String) table)
    // z toho fieldu neziskat genericke typy - classy
    // Jozo Hartinger - jak Weld precte @Inject Event<EventType>; event.fire(new EventType());
    
    // List<String> list; list.get(1);
    
//    @FindBy
//    private TableOfPersons tableOfPersons;
//    
//    Column<String> tableOfPersons.getColumn1()
    
    
    // 
    
    // 

    // implementovat typ tabulka zo 6 stlpcami, TableOfUsers implements DataTable6ColTypesImpl<String, String, Integer, String,
    // String, CalendarPopupComponentImpl>
    //
    // Table.create(String.class, String.class, Integer.class, String.class, String.class, CalendarPopupComponentImpl.class);

    @Deployment(testable = false)
    public static WebArchive deploy() {
        return createDeployment(TestDataTableComponent.class).addClass(PersonBean.class);
    }

    @Test
    public void testFoo() {
    }
}
