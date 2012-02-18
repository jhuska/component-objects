package cz.fi.muni.jhuska.bc.test;

import java.io.File;

import org.apache.commons.lang.WordUtils;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.testng.Arquillian;
import org.jboss.shrinkwrap.api.ArchivePaths;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.resolver.api.DependencyResolvers;
import org.jboss.shrinkwrap.resolver.api.maven.MavenDependencyResolver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;

public class AbstractTest extends Arquillian {

    protected WebDriver webDriver;

    private static final String WEBAPP_SRC = "src/test/webapp";

    protected static WebArchive createDeployment(Class<?> testClazz) {
        MavenDependencyResolver resolver = DependencyResolvers.use(MavenDependencyResolver.class)
            .loadMetadataFromPom("pom.xml");

        String simpleNameOfTestClass = createNameOfScrFileFromTestClass(testClazz.getSimpleName());

        WebArchive war = ShrinkWrap
            .create(WebArchive.class, "ftest-app.war")
            .addAsDirectories(ArchivePaths.create("templates"))
            .addAsWebResource(new File(WEBAPP_SRC + "/templates/template.xhtml"),
                ArchivePaths.create("templates/template.xhtml"))
            .addAsWebInfResource(new File(WEBAPP_SRC + "/WEB-INF/web.xml"))
            .addAsWebInfResource(new File(WEBAPP_SRC + "/WEB-INF/faces-config.xml"))
            .addAsWebResource(new File(WEBAPP_SRC + "/components/" + simpleNameOfTestClass + ".xhtml"),
                ArchivePaths.create("components/" + simpleNameOfTestClass + ".xhtml"))
            .addAsWebResource(new File(WEBAPP_SRC + "/resources/script/jquery-min.js"),
                ArchivePaths.create("resources/script/jquery-min.js"))
            .addAsLibraries(
                resolver.artifacts("org.richfaces.ui:richfaces-components-ui", "org.richfaces.core:richfaces-core-impl")
                    .resolveAsFiles());

        return war;
    }

    @BeforeMethod
    public void loadTestPage() {
        webDriver.get("http://localhost:8080/ftest-app/components/" + getAdditionToContextRoot() + ".jsf");
    }

    protected String getAdditionToContextRoot() {
        // sample name - removes Test- prefix from class name and uncapitalize
        // first letter
        String sampleName = createNameOfScrFileFromTestClass(this.getClass().getSimpleName());

        return sampleName;
    }

    private static String createNameOfScrFileFromTestClass(String className) {
        String sampleName = className.substring(4);
        sampleName = WordUtils.uncapitalize(sampleName);

        return sampleName;
    }
}