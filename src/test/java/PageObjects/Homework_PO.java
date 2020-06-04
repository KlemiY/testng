package test.java.PageObjects;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class Homework_PO extends TestingSetup {
    LandPage landPage;
    LaptopsPage laptopsPage;

    @BeforeMethod
    public void initialize() {
        landPage = new LandPage(driver);
        laptopsPage = new LaptopsPage(driver);
    }

    @Test
    public void appleProductsSearch() {
        landPage.open();
        landPage.search("Apple");
        //Checking correct amount of products type.
        List<WebElement> productLinks = landPage.productType;
        for (WebElement element : productLinks) {
            int expectedAmount = 5;
            int actualAmount = productLinks.size();
            assertEquals(expectedAmount, actualAmount,
                    "Expected amount is " + expectedAmount + ", but got " + actualAmount + "."
            );
        }
    }

    @Test
    public void samsungProductsSearch() {
        landPage.open();
        landPage.search("Samsung");
        //Checking correct amount of products type.
        List<WebElement> productLinks = landPage.productType;
        for (WebElement element : productLinks) {
            int expectedAmount = 9;
            int actualAmount = productLinks.size();
            assertEquals(expectedAmount, actualAmount,
                    "Expected amount is " + expectedAmount + ", but got " + actualAmount + "."
            );
        }
    }

    @Test//(dataProvider = "laptopModels")
    public void laptopSearch() {
        laptopsPage.open();
        laptopsPage.selectProductCheckbox();
        List<WebElement> allItems = laptopsPage.laptopItems;
        String [] itemsText = new String[allItems.size()];
        int i=0;
        //Storing List elements text into String array
        for(WebElement element: allItems) {
            itemsText[i]=element.getText();
            i++;
            System.out.println(element.getText());
        }
    }


    @Test //Для проверки на возвращение тектса.
    public void textReturn() {
        laptopsPage.open();
        laptopsPage.selectProductCheckbox();
        List<WebElement> allItems = laptopsPage.laptopItems;
        String [] itemsText = new String[allItems.size()];
        int i=0;
        //Storing List elements text into String array
        for(WebElement element: allItems) {
            itemsText[i]=element.getText();
            i++;
            System.out.println(element.getText());
        }
        /*String expectedProducer = "^Ноутбук Acer.*";
        Object[] actualProducer = new String[] {
                "Ноутбук Acer Swift 3 SF314-58-52DU (NX.HPMEU.00L) Sparkly Silver Суперцена!!!",
                "Ноутбук Acer Aspire 3 A315-34-C1SZ (NX.HE3EU.016) Black Суперцена!!!",
                "Ноутбук Acer Swift 3 SF314-41-R1EL (NX.HFDEU.006) Sparkly Silver Суперцена!!!",
                "Ноутбук Acer Aspire 5 A515-54G-56DQ (NX.HN0EU.00R) Charcoal Black Суперцена!!!",
                "Ноутбук Acer Aspire 5 A514-52-51QC (NX.HLZEU.006) Charcoal Black Суперцена!!!",
                "Ноутбук Acer Aspire 5 A514-52-363E (NX.HLZEU.002) Charcoal Black Суперцена!!!",
                "Ноутбук Acer Aspire 5 A515-52G (NX.H5LEU.010) Pure Silver",
                "Ноутбук Acer Extensa 15 EX215-51K-38QX (NX.EFPEU.009) Shale Black",
                "Ноутбук Acer Aspire 3 A315-42-R2HC (NX.HF9EU.039) Shale Black",
                "Ноутбук Acer Aspire 5 A515-52G (NX.H15EU.005) Obsidian Black Суперцена!!!",
                "Ноутбук Acer Extensa 15 EX215-51K-36XU (NX.EFPEU.00B) Shale Black",
                "Ноутбук Acer Aspire 3 A315-42G-R5FR (NX.HF8EU.010) Shale Black Суперцена!!!",
                "Ноутбук Acer Predator Helios 300 PH315-52-56JQ (NH.Q54EU.015) Abyssal Black",
                "Ноутбук Acer Extensa 15 EX2519-P6A1 (NX.EFAEU.088) Black",
                "Ноутбук Acer Aspire 3 A315-55G-586W (NX.HEDEU.06D) Black",
                "Ноутбук Acer Aspire 3 A315-53-P8TY (NX.H38EU.044) Obsidian Black",
                "Ноутбук Acer Aspire 7 A715-72G-5610 (NH.GXCEU.058) Obsidian Black",
                "Ноутбук Acer Aspire 3 A315-56-52W9 (NX.HS7EU.00E) Rococo Red",
                "Ноутбук Acer Swift 3 SF314-58-50RX (NX.HPMEU.00J) Sparkly Silver",
                "Ноутбук Acer Aspire 3 A317-51-340J (NX.HLYEU.008) Shale Black",
                "Ноутбук Acer Predator Helios 300 PH317-53-70GH (NH.Q5REU.011) Abyssal Black",
                "Ноутбук Acer Aspire 5 A515-54G-71D3 (NX.HVGEU.00C) Pure Silver",
                "Ноутбук Acer Aspire 3 A315-34-P462 (NX.HE3EU.03N) Charcoal Black",
                "Ноутбук Acer Nitro 5 AN515-54-5791 (NH.Q59EU.055) Shale Black",
                "Ноутбук Acer Nitro 5 AN517-51-76C5 (NH.Q5CEU.025) Shale Black",
                "Ноутбук Acer Aspire 3 A317-51G-76BX (NX.HM1EU.00P) Shale Black",
                "Ноутбук Acer Aspire 3 A315-34-P4HQ (NX.HG9EU.015) Indigo Blue",
                "Ноутбук Acer Aspire 3 A315-42-R7YR (NX.HHNEU.00C) Indigo Blue",
                "Ноутбук Acer Aspire 3 A315-54K-53PZ (NX.HEEEU.036) Shale Black",
                "Ноутбук Acer Aspire 3 A315-54K-52ZT (NX.HEEEU.034) Shale Black",
                "Ноутбук Acer Nitro 5 AN517-51-73EZ (NH.Q9BEU.00A) Obsidian Black",
                "Ноутбук Acer Aspire 3 A315-54K-58LK (NX.HEEEU.03J) Shale Black",
                "Ноутбук Acer Swift 3 SF314-57G-582F (NX.HUKEU.002) Steel Gray",
                "Ноутбук Acer Aspire 5 A515-54G-3968 (NX.HS8EU.004) Charcoal Black",
                "Ноутбук Acer Nitro 5 AN515-54-79LW (NH.Q59EU.09E) Shale Black",
                "Ноутбук Acer Aspire 3 A317-51G-523E (NX.HM1EU.00A) Shale Black",
                "Ноутбук Acer Nitro 5 AN515-43-R112 (NH.Q5XEU.041) Obsidian Black",
                "Ноутбук Acer Aspire 3 A315-54K-57WL (NX.HEEEU.03M) Shale Black",
                "Ноутбук Acer Swift 3 SF314-58-32FK (NX.HPSEU.00G) Sakura Pink",
                "Ноутбук Acer Aspire 3 A315-41G (NX.GYBEU.014) Obsidian Black",
                "Ноутбук Acer Swift 3 SF314-57G-54MT (NX.HUJEU.002) Millennial Pink",
                "Ноутбук Acer Nitro 5 AN517-51-754M (NH.Q5DEU.015) Shale Black",
                "Ноутбук Acer Predator Helios 300 PH315-52-76JZ (NH.Q54EU.037) Abyssal Black",
                "Ноутбук Acer Aspire 3 A315-34-P34D (NX.HGAEU.010) Lava Red",
                "Ноутбук Acer Aspire 5 A515-54G-58QZ (NX.HN0EU.00M) Charcoal Black",
                "Ноутбук Acer Nitro 7 AN715-51-7811 (NH.Q5HEU.026) Shale Black",
                "Ноутбук Acer Aspire 3 A315-55G-59J2 (NX.HEDEU.05L) Black",
                "Ноутбук Acer Aspire 3 A315-56-38ZD (NX.HS5EU.00L) Shale Black",
                "Ноутбук Acer Swift 3 SF314-57G-782Q (NX.HUGEU.008) Glacier Blue",
                "Ноутбук Acer Nitro 5 AN517-51-782L (NH.Q5DEU.025) Shale Black",
                "Ноутбук Acer Aspire 3 A315-42-R09C (NX.HF9EU.048) Shale Black",
                "Ноутбук Acer Predator Helios 300 PH315-52-506T (NH.Q54EU.019) Abyssal Black",
                "Ноутбук Acer Aspire 3 A317-32-P79K (NX.HF2EU.014) Shale Black",
                "Ноутбук Acer Nitro 5 AN517-51-71V5 (NH.Q5DEU.013) Obsidian Black",
                "Ноутбук Acer Aspire 3 A315-42-R1W5 (NX.HHPEU.006) Rococo Red",
                "Ноутбук Acer Swift 5 SF514-54GT-52CN (NX.HU6EU.002) Moonstone White",
                "Ноутбук Acer Nitro 5 AN515-54-723L (NH.Q59EU.033) Obsidian Black",
                "Ноутбук Acer Aspire 3 A315-42G-R0MZ (NX.HHQEU.008) Indigo Blue",
                "Ноутбук Acer Aspire 3 A315-56-54SE (NX.HS6EU.00C) Indigo Blue",
                "Ноутбук Acer Aspire 5 A515-54G-57RF (NX.HVGEU.008) Pure Silver"
        };
        assertEquals(expectedProducer, actualProducer);*/

        /*WebElement oneItem = driver.findElement(By.xpath("//li/a//*[contains(text(),'Acer')]"));
        String text1 = oneItem.getText();
        System.out.println("Text =" + text1);*/
    }
    @DataProvider(name = "laptopModels")
    public Object[][] getCssSelector() {
        return new Object[][] {
                {"//li/a//*[contains(text(),'Acer')]"},
                {"//li/a//*[contains(text(),'Apple')]"},
                {"//li/a//*[contains(text(),'Asus')]"}
        };
    }

}



