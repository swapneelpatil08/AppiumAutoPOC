package tests;

import Pages.TouchActionsPage;
import Pages.YouTubePage;
import org.testng.annotations.Test;

public class TouchActionTests extends TouchActionsPage {

    public TouchActionTests() throws Exception {
    }
    YouTubePage youTubePage = new YouTubePage(androidDriver);

    @Test
    public void SeekBarTest(){
        String searchText = "Mobile Testing";
        youTubePage.search(searchText);
        youTubePage.clickSearch();
//        youTubePage.selectFirstResult(searchText);
        youTubePage.playFirstVideo();
        waitForAdvertiserToDisappear();
        moveSeekBar();
    }
}
