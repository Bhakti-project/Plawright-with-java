package Pages;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

import javax.imageio.ImageIO;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class ImagePages {

	private Page page;

	public ImagePages(Page page) {
		this.page = page;
	}

	public void navigateTOProductPage() {
		page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Products")).click();

	}

	public void productpageTakeScreenshot() {
		 page.screenshot(new
		 Page.ScreenshotOptions().setPath(Paths.get("target/Screenshot/Actual2.png")));

	//	page.getByRole(AriaRole.IMG, new Page.GetByRoleOptions().setName("Website for automation"))
		//		.screenshot(new Locator.ScreenshotOptions().setPath(Paths.get("target/Screenshot/locatoractual.png")));
	}

	public boolean comparetheImage(String actualpath, String expectedpath) throws IOException {

		String actualpath1 = "target/Screenshot/Actual2.png";
		String expectedpath1 = "target/Screenshot/ActualTake.png";
		BufferedImage expected = ImageIO.read(new File(expectedpath1));
		BufferedImage actual = ImageIO.read(new File(actualpath1));

		int width = Math.min(expected.getWidth(), actual.getWidth());
		int height = Math.min(expected.getHeight(), actual.getHeight());

		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				if (expected.getRGB(x, y) != actual.getRGB(x, y)) {
					return false;
				}
			}
		}
		return true;

	}

}
