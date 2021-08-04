package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductsPage {
    public WebDriver ldriver;

    public ProductsPage(WebDriver driver)
    {
        ldriver=driver;
        PageFactory.initElements(ldriver,this);
    }


    @FindBy(xpath="//div[@class='spend-save-plans']//div//div//div[@class='plan-content']")
    List<WebElement> productslist;

    @FindBy(xpath="//div[@class='spend-save-plans']//div//div//div[@class='plan-content']//h2")
    List<WebElement> productslistnames;

    @FindBy(xpath="//div[@class='spend-save-plans']//div//div//div[@class='plan-content']//button")
    List<WebElement> productplanbuttons;

    @FindBy(xpath="//*[@id='join-waitlist-input']")
    WebElement signuptextbox;

    @FindBy(xpath="//div[@class='modal-dialog ']")
    WebElement modalyearlymonthly;

    @FindBy(xpath="//div[@class='modal-body ng-scope']//div[@class='options']//div//h3")
    List<WebElement> plan_type; // get yearly or monthly message

    @FindBy(xpath="//div[@class='modal-body ng-scope']//div[@class='options']//div//p//b")
    List<WebElement> plan_cost;


    public void verifyProductsPageDisplayed()
    {
        String productPageTitle=ldriver.getTitle();
        Assert.assertEquals("Cash Management Services - Investing & Retirement Planning | Aspiration" ,productPageTitle);
    }
    public void verifyProductsDisplayed()
    {

        System.out.println("products count: "+productslist.size());
        for(int i=0; i< productslist.size();i++)
        {
            if(productslist.get(i).isDisplayed())
            {
                int a=i+1;
                System.out.println("we are able to see product:"+a);
            }
        }

    }
    public void verfiyNamesOfProductsDisplayed(String prod1,String prod2)
    {
        System.out.println("entering verification of names");
        String productnames[]={prod1,prod2};
        for(int i=0; i< productslistnames.size();i++)
        {
            String text=productslistnames.get(i).getText();
            if(text.equals(productnames[i]))
            {
                System.out.println("Name of  product:"+i + "  is verified and its name is :" +text);
            }
            else
            {
                System.out.println(text);
            }
        }
    }
    public void clickOnProductPlanButton(String buttontext)
    {

        JavascriptExecutor js=(JavascriptExecutor) ldriver;

        System.out.println("click on buttons and their count :"+productplanbuttons.size());
        for(int i=0; i< productplanbuttons.size();i++)
        {
            String text=productplanbuttons.get(i).getText();
            if(text.equals(buttontext))
            {
                System.out.println("clicking button with text :"+text);
                productplanbuttons.get(i).click();
                /*WebElement element=productplanbuttons.get(i);
                System.out.println("got the element for js");
                element.click();
                System.out.println("clicked on button");
                js.executeScript("return arguments[0].srollIntoView(true);",element);
                System.out.println("scrooled to element");
                js.executeScript("arguments[0].click();",element);*/
                System.out.println("clicked on button");
                break;
            }
            else
            {
                System.out.println("found button with text and not clicking on the button:"+text);
            }
        }
    }

    public void verifysignupinputfield()
    {
       if(signuptextbox.isDisplayed())
        {
            System.out.println("email signup box is displayed");
        }
        else
        {
            System.out.println("email signup textbox is not displayed");
        }
    }
    public void MonthlyYearlyPlanModelDisplay()
    {
        if(modalyearlymonthly.isDisplayed())
        {
            System.out.println("modal with monthly and yearly plan appeared");
        }
        else
        {
            System.out.println("modal of monthly and yearly plan didnot appear");
        }
    }
    public void verifyPlanAndCost(String actualplaninformation,String actualcost)
    {
        for(int i=0; i< plan_type.size(); i++)
        {
            String text = plan_type.get(i).getText();
            if (text.equalsIgnoreCase(actualplaninformation)) {
                System.out.println(" plan text verified and it is  :" + text);
                System.out.println("verifing cost of the plan now:");
                Assert.assertEquals(actualcost, plan_cost.get(i).getText());

                System.out.println(" verified plan cost :" + plan_cost.get(i).getText());
                break;
            } else {
                String checksubstring=text.substring(text.indexOf('Y'),text.indexOf('y')+1);
               // System.out.println("substring is :"+checksubstring);
               // System.out.println("actual string:"+actualplaninformation);
                if(checksubstring.equalsIgnoreCase(actualplaninformation))
                {
                    System.out.println(" plan text verified and it is  :" + text);
                    System.out.println("verifing cost of the plan now:");
                    Assert.assertEquals(actualcost, plan_cost.get(i).getText());

                    System.out.println(" verified plan cost :" + plan_cost.get(i).getText());
                    break;
                }
                else
                    System.out.println("plan string not at all matching and it is :"+text);
            }
        }
    }
}
