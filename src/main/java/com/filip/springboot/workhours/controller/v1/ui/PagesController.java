package com.filip.springboot.workhours.controller.v1.ui;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class PagesController {

    private static final Logger logger = LoggerFactory.getLogger(PagesController.class);

    @GetMapping(value = "/workyear")
    public ModelAndView getWorkMonth() {
        ModelAndView modelAndView = new ModelAndView("workyear");

        List<String> months = Arrays.asList("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December");

        modelAndView.addObject("months", months);

        return modelAndView;
    }

    @GetMapping(value = "/samples/pages-blank")
    public ModelAndView getPagesBlank() {
        return new ModelAndView("samplepages/pages-blank");
    }

    @GetMapping(value = "/samples/icon-simple-lineicon")
    public ModelAndView getPagesIconSimpleLineicon() {
        return new ModelAndView("samplepages/icon-simple-lineicon");
    }


    @GetMapping(value = "/samples/icon-flag")
    public ModelAndView getPagesIconFlag() {
        return new ModelAndView("samplepages/icon-flag");
    }

    @GetMapping(value = "/samples/icon-weather")
    public ModelAndView getPagesIconWeather() {
        return new ModelAndView("samplepages/icon-weather");
    }

    @GetMapping(value = "/samples/icon-linea")
    public ModelAndView getPagesIconLinea() {
        return new ModelAndView("samplepages/icon-linea");
    }

    @GetMapping(value = "/samples/icon-themify")
    public ModelAndView getPagesIconThemify() {
        return new ModelAndView("samplepages/icon-themify");
    }

    @GetMapping(value = "/samples/icon-fontawesome")
    public ModelAndView getPagesIconfontawesome() {
        return new ModelAndView("samplepages/icon-fontawesome");
    }

    @GetMapping(value = "/samples/icon-material")
    public ModelAndView getPagesIconmaterial() {
        return new ModelAndView("samplepages/icon-material");
    }

    @GetMapping(value = "/samples/map-vector")
    public ModelAndView getPagesMapVector() {
        return new ModelAndView("samplepages/map-vector");
    }

    @GetMapping(value = "/samples/map-google")
    public ModelAndView getPagesMapGoogle() {
        return new ModelAndView("samplepages/map-google");
    }

    @GetMapping(value = "/samples/dashboard2")
    public ModelAndView getPagesDashboard2() {
        return new ModelAndView("samplepages/dashboard2");
    }

    @GetMapping(value = "/samples/dashboard3")
    public ModelAndView getPagesDashboard3() {
        return new ModelAndView("samplepages/dashboard3");
    }

    @GetMapping(value = "/samples/dashboard4")
    public ModelAndView getPagesDashboard4() {
        return new ModelAndView("samplepages/dashboard4");
    }

    @GetMapping(value = "/samples/dashboard5")
    public ModelAndView getPagesDashboard5() {
        return new ModelAndView("samplepages/dashboard5");
    }

    @GetMapping(value = "/samples/dashboard6")
    public ModelAndView getPagesDashboard6() {
        return new ModelAndView("samplepages/dashboard6");
    }

    @GetMapping(value = "/samples/chart-morris")
    public ModelAndView getPagesChartMorris() {
        return new ModelAndView("samplepages/chart-morris");
    }

    @GetMapping(value = "/samples/chart-chartist")
    public ModelAndView getPagesChartchartist() {
        return new ModelAndView("samplepages/chart-chartist");
    }

    @GetMapping(value = "/samples/chart-echart")
    public ModelAndView getPagesChartechart() {
        return new ModelAndView("samplepages/chart-echart");
    }


    @GetMapping(value = "/samples/chart-flot")
    public ModelAndView getPagesChartflot() {
        return new ModelAndView("samplepages/chart-flot");
    }


    @GetMapping(value = "/samples/chart-knob")
    public ModelAndView getPagesChartknob() {
        return new ModelAndView("samplepages/chart-knob");
    }


    @GetMapping(value = "/samples/chart-chart-js")
    public ModelAndView getPagesChartchartjs() {
        return new ModelAndView("samplepages/chart-chart-js");
    }


    @GetMapping(value = "/samples/chart-sparkline")
    public ModelAndView getPagesChartsparkline() {
        return new ModelAndView("samplepages/chart-sparkline");
    }


    @GetMapping(value = "/samples/chart-extra-chart")
    public ModelAndView getPagesChartextrachart() {
        return new ModelAndView("samplepages/chart-extra-chart");
    }


    @GetMapping(value = "/samples/chart-peity")
    public ModelAndView getPagesChartpeity() {
        return new ModelAndView("samplepages/chart-peity");
    }


    @GetMapping(value = "/samples/pages-error-400")
    public ModelAndView getPagesError400() {
        return new ModelAndView("samplepages/pages-error-400");
    }

    @GetMapping(value = "/samples/pages-error-403")
    public ModelAndView getPagesError403() {
        return new ModelAndView("samplepages/pages-error-403");
    }

    @GetMapping(value = "/samples/pages-error-404")
    public ModelAndView getPagesError404() {
        return new ModelAndView("samplepages/pages-error-404");
    }

    @GetMapping(value = "/samples/pages-error-500")
    public ModelAndView getPagesError500() {
        return new ModelAndView("samplepages/pages-error-500");
    }

    @GetMapping(value = "/samples/pages-error-503")
    public ModelAndView getPagesError503() {
        return new ModelAndView("samplepages/pages-error-503");
    }

    @GetMapping(value = "/samples/pages-faq")
    public ModelAndView getPagesfaq() {
        return new ModelAndView("samplepages/pages-faq");
    }

    @GetMapping(value = "/samples/pages-gallery")
    public ModelAndView getPagesgallery() {
        return new ModelAndView("samplepages/pages-gallery");
    }

    @GetMapping(value = "/samples/pages-pricing")
    public ModelAndView getPagespricing() {
        return new ModelAndView("samplepages/pages-pricing");
    }

    @GetMapping(value = "/samples/pages-scroll")
    public ModelAndView getPagesscroll() {
        return new ModelAndView("samplepages/pages-scroll");
    }

    @GetMapping(value = "/samples/pages-lightbox-popup")
    public ModelAndView getPageslightboxpopup() {
        return new ModelAndView("samplepages/pages-lightbox-popup");
    }

    @GetMapping(value = "/samples/pages-search-result")
    public ModelAndView getPagessearchresult() {
        return new ModelAndView("samplepages/pages-search-result");
    }

    @GetMapping(value = "/samples/pages-utility-classes")
    public ModelAndView getPagesutilityclasses() {
        return new ModelAndView("samplepages/pages-utility-classes");
    }

    @GetMapping(value = "/samples/pages-treeview")
    public ModelAndView getPagestreeview() {
        return new ModelAndView("samplepages/pages-treeview");
    }

    @GetMapping(value = "/samples/pages-invoice")
    public ModelAndView getPagesinvoice() {
        return new ModelAndView("samplepages/pages-invoice");
    }

    @GetMapping(value = "/samples/pages-animation")
    public ModelAndView getPagesanimation() {
        return new ModelAndView("samplepages/pages-animation");
    }

    @GetMapping(value = "/samples/pages-profile")
    public ModelAndView getPagesprofile() {
        return new ModelAndView("samplepages/pages-profile");
    }

    @GetMapping(value = "/samples/pages-fix-innersidebar")
    public ModelAndView getPagesfixinnersidebar() {
        return new ModelAndView("samplepages/pages-fix-innersidebar");
    }

    @GetMapping(value = "/samples/pages-fix-inner-right-sidebar")
    public ModelAndView getPagesfixinnerrightsidebar() {
        return new ModelAndView("samplepages/pages-fix-inner-right-sidebar");
    }

    @GetMapping(value = "/samples/pages-recover-password")
    public ModelAndView getPagesrecoverpassword() {
        return new ModelAndView("samplepages/pages-recover-password");
    }

    @GetMapping(value = "/samples/pages-lockscreen")
    public ModelAndView getPageslockscreen() {
        return new ModelAndView("samplepages/pages-lockscreen");
    }

    @GetMapping(value = "/samples/pages-register")
    public ModelAndView getPagesregister() {
        return new ModelAndView("samplepages/pages-register");
    }

    @GetMapping(value = "/samples/pages-login")
    public ModelAndView getPageslogin() {
        return new ModelAndView("samplepages/pages-login");
    }

    @GetMapping(value = "/samples/pages-app-calendar")
    public ModelAndView getPagesappcalendar() {
        return new ModelAndView("samplepages/app-calendar");
    }

    @GetMapping(value = "/samples/app-chat")
    public ModelAndView getPagesappchat() {
        return new ModelAndView("samplepages/app-chat");
    }

    @GetMapping(value = "/samples/app-ticket")
    public ModelAndView getPagesappticket() {
        return new ModelAndView("samplepages/app-ticket");
    }

    @GetMapping(value = "/samples/app-contact")
    public ModelAndView getPagesappcontact() {
        return new ModelAndView("samplepages/app-contact");
    }

    @GetMapping(value = "/samples/app-contact2")
    public ModelAndView getPagesappcontact2() {
        return new ModelAndView("samplepages/app-contact2");
    }

    @GetMapping(value = "/samples/pages-app-contact-detail")
    public ModelAndView getPagesappcontactdetail() {
        return new ModelAndView("samplepages/app-contact-detail");
    }

    @GetMapping(value = "/samples/app-email")
    public ModelAndView getPagesappemail() {
        return new ModelAndView("samplepages/app-email");
    }

    @GetMapping(value = "/samples/app-email-detail")
    public ModelAndView getPagesappemaildetail() {
        return new ModelAndView("samplepages/app-email-detail");
    }

    @GetMapping(value = "/samples/app-compose")
    public ModelAndView getPagesappcompose() {
        return new ModelAndView("samplepages/app-compose");
    }

    @GetMapping(value = "/samples/ui-cards")
    public ModelAndView getPagesuicards() {
        return new ModelAndView("samplepages/ui-cards");
    }

    @GetMapping(value = "/samples/ui-user-card")
    public ModelAndView getPagesuiusercard() {
        return new ModelAndView("samplepages/ui-user-card");
    }

    @GetMapping(value = "/samples/ui-buttons")
    public ModelAndView getPagesuibuttons() {
        return new ModelAndView("samplepages/ui-buttons");
    }

    @GetMapping(value = "/samples/ui-modals")
    public ModelAndView getPagesuimodals() {
        return new ModelAndView("samplepages/ui-modals");
    }

    @GetMapping(value = "/samples/ui-tab")
    public ModelAndView getPagesuitab() {
        return new ModelAndView("samplepages/ui-tab");
    }

    @GetMapping(value = "/samples/ui-tooltip-popover")
    public ModelAndView getPagesuitooltippopover() {
        return new ModelAndView("samplepages/ui-tooltip-popover");
    }

    @GetMapping(value = "/samples/ui-tooltip-stylish")
    public ModelAndView getPagesuitooltipstylish() {
        return new ModelAndView("samplepages/ui-tooltip-stylish");
    }

    @GetMapping(value = "/samples/ui-sweetalert")
    public ModelAndView getPagesuisweetalert() {
        return new ModelAndView("samplepages/ui-sweetalert");
    }

    @GetMapping(value = "/samples/ui-notification")
    public ModelAndView getPagesuinotification() {
        return new ModelAndView("samplepages/ui-notification");
    }

    @GetMapping(value = "/samples/ui-progressbar")
    public ModelAndView getPagesuiprogressbar() {
        return new ModelAndView("samplepages/ui-progressbar");
    }

    @GetMapping(value = "/samples/ui-nestable")
    public ModelAndView getPagesuinestable() {
        return new ModelAndView("samplepages/ui-nestable");
    }

    @GetMapping(value = "/samples/ui-range-slider")
    public ModelAndView getPagesuirangeslider() {
        return new ModelAndView("samplepages/ui-range-slider");
    }

    @GetMapping(value = "/samples/ui-timeline")
    public ModelAndView getPagesuitimeline() {
        return new ModelAndView("samplepages/ui-timeline");
    }

    @GetMapping(value = "/samples/ui-typography")
    public ModelAndView getPagesuitypography() {
        return new ModelAndView("samplepages/ui-typography");
    }

    @GetMapping(value = "/samples/ui-horizontal-timeline")
    public ModelAndView getPagesuihorizontaltimeline() {
        return new ModelAndView("samplepages/ui-horizontal-timeline");
    }

    @GetMapping(value = "/samples/ui-session-timeout")
    public ModelAndView getPagesuisessiontimeout() {
        return new ModelAndView("samplepages/ui-session-timeout");
    }

    @GetMapping(value = "/samples/ui-session-ideal-timeout")
    public ModelAndView getPagesuisessionidealtimeout() {
        return new ModelAndView("samplepages/ui-session-ideal-timeout");
    }

    @GetMapping(value = "/samples/ui-bootstrap")
    public ModelAndView getPagesuibootstrap() {
        return new ModelAndView("samplepages/ui-bootstrap");
    }

    @GetMapping(value = "/samples/ui-breadcrumb")
    public ModelAndView getPagesuibreadcrumb() {
        return new ModelAndView("samplepages/ui-breadcrumb");
    }

    @GetMapping(value = "/samples/ui-list-media")
    public ModelAndView getPagesuilistmedia() {
        return new ModelAndView("samplepages/ui-list-media");
    }

    @GetMapping(value = "/samples/ui-ribbons")
    public ModelAndView getPagesuiribbons() {
        return new ModelAndView("samplepages/ui-ribbons");
    }

    @GetMapping(value = "/samples/ui-grid")
    public ModelAndView getPagesuigrid() {
        return new ModelAndView("samplepages/ui-grid");
    }

    @GetMapping(value = "/samples/ui-carousel")
    public ModelAndView getPagesuicarousel() {
        return new ModelAndView("samplepages/ui-carousel");
    }

    @GetMapping(value = "/samples/ui-date-paginator")
    public ModelAndView getPagesuidatepaginator() {
        return new ModelAndView("samplepages/ui-date-paginator");
    }

    @GetMapping(value = "/samples/ui-dragable-portlet")
    public ModelAndView getPagesuidragableportlet() {
        return new ModelAndView("samplepages/ui-dragable-portlet");
    }

    @GetMapping(value = "/samples/ui-scrollspy")
    public ModelAndView getPagesuiscrollspy() {
        return new ModelAndView("samplepages/ui-scrollspy");
    }

    @GetMapping(value = "/samples/ui-toasts")
    public ModelAndView getPagesuitoasts() {
        return new ModelAndView("samplepages/ui-toasts");
    }

    @GetMapping(value = "/samples/ui-spinner")
    public ModelAndView getPagesuispinner() {
        return new ModelAndView("samplepages/ui-spinner");
    }

}
