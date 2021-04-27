package sg.edu.rp.c346.s19047241.p03_classjournalteam;

import java.io.Serializable;
import java.util.ArrayList;

public class Module implements Serializable {

    private String moduleCode, moduleName;
    private String dailyCA;
    private ArrayList<DailyCA> alDailyCA;
    private String inCharge;
    private String infoUrl;

    public Module(String moduleCode, String moduleName, String inCharge, String infoUrl){
        this.moduleName = moduleName;
        this.moduleCode = moduleCode;
        this.inCharge = inCharge;
        this.infoUrl = infoUrl;
    }

    public String getModuleCode() {
        return moduleCode;
    }

    public void setModuleCode(String moduleCode) {
        this.moduleCode = moduleCode;
    }

    public String getDailyCA() {
        return dailyCA;
    }

    public void setDailyCA(String dailyCA) {
        this.dailyCA = dailyCA;
    }

    public ArrayList<DailyCA> getAlDailyCA() {
        return alDailyCA;
    }

    public void setAlDailyCA(ArrayList<DailyCA> alDailyCA) {
        this.alDailyCA = alDailyCA;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getInCharge() {
        return inCharge;
    }

    public void setInCharge(String inCharge) {
        this.inCharge = inCharge;
    }


    public String getInfoUrl() {
        return infoUrl;
    }

    public void setInfoUrl(String infoUrl) {
        this.infoUrl = infoUrl;
    }
}
