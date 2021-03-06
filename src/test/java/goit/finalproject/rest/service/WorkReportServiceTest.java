package goit.finalproject.rest.service;

import goit.finalproject.rest.Service.WorkReportService;
import goit.finalproject.rest.model.WorkReport;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@SpringBootTest
@RunWith(SpringRunner.class)
@ActiveProfiles("testing") //application-testing.properties
public class WorkReportServiceTest {

    @Autowired
    private WorkReportService workReportService;

    @Before
    public void beforeTest(){
        workReportService.deleteAll();
    }

    @Test
    public void saveTest(){
        WorkReport workReport = new WorkReport(1112L, "02 01 2018", "15 01 2018");
        workReport.setCountDay(5);
        workReport.setSalaryPeriod(20000f);
        workReportService.add(workReport);

        List<WorkReport> found = workReportService.findReportByEmployeeAndBeginPeriodAndEndPeriod(
                                 1112L, "02 01 2018", "15 01 2018");
        assertEquals(workReport, found.get(0));
    }

    @Test
    public void findAllTest(){

    }
}
