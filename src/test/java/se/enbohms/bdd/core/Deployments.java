package se.enbohms.bdd.core;

import java.io.File;

import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.StringAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;

import se.enbohms.bdd.service.RewardService;

/**
 * Utility class which is responsible for creating different deployments
 * 
 * @author enbohm
 *
 */
public class Deployments {
	private static final String WEBAPP_SRC = "src/main/webapp";

	private Deployments() {
		// // Suppresses default constructor, ensuring non-instantiability.
	}

	/**
	 * 
	 * @return a full deployment unit, all resources included.
	 */
	public static Archive<?> createFullDeployment() {
		WebArchive war = ShrinkWrap.create(WebArchive.class, "BDD_Demo.war");
		war.addClass(RewardService.class);
		war.addAsWebResource(new File(WEBAPP_SRC,"index.xhtml"));

		war.addAsManifestResource(new File(WEBAPP_SRC,"/WEB-INF/web.xml"));
		war.setWebXML(new File(WEBAPP_SRC, "/WEB-INF/web.xml"));
		war.addAsWebInfResource(
                new StringAsset("<faces-config version=\"2.0\"/>"),
                "faces-config.xml");
		return war;
	}
}
