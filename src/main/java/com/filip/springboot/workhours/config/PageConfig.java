package com.filip.springboot.workhours.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Created by Arpit Khandelwal.
 */
@Configuration
public class PageConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
                .addResourceHandler("/webjars/**")
                .addResourceLocations("/webjars/")
                .resourceChain(false);
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/home").setViewName("home");
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/dashboard").setViewName("dashboard");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/signup").setViewName("signup");
        registry.addViewController("/profile").setViewName("profile");
        registry.addViewController("/agency").setViewName("agency");
        registry.addViewController("/bus").setViewName("bus");
        registry.addViewController("/trip").setViewName("trip");
        registry.addViewController("/logout").setViewName("logout");
        registry.addViewController("/workmonth").setViewName("workmonth");


        registry.addViewController("/samples/pages-blank").setViewName("samplepages/pages-blank");
        registry.addViewController("/samples/icon-simple-lineicon").setViewName("samplepages/icon-simple-lineicon");
        registry.addViewController("/samples/icon-flag").setViewName("samplepages/icon-flag");
        registry.addViewController("/samples/icon-weather").setViewName("samplepages/icon-weather");
        registry.addViewController("/samples/icon-linea").setViewName("samplepages/icon-linea");
        registry.addViewController("/samples/icon-themify").setViewName("samplepages/icon-themify");
        registry.addViewController("/samples/icon-fontawesome").setViewName("samplepages/icon-fontawesome");
        registry.addViewController("/samples/icon-material").setViewName("samplepages/icon-material");
        registry.addViewController("/samples/map-vector").setViewName("samplepages/map-vector");
        registry.addViewController("/samples/map-google").setViewName("samplepages/map-google");

        registry.addViewController("/samples/dashboard2").setViewName("samplepages/dashboard2");
        registry.addViewController("/samples/dashboard3").setViewName("samplepages/dashboard3");
        registry.addViewController("/samples/dashboard4").setViewName("samplepages/dashboard4");
        registry.addViewController("/samples/dashboard5").setViewName("samplepages/dashboard5");
        registry.addViewController("/samples/dashboard6").setViewName("samplepages/dashboard6");

        registry.addViewController("/samples/chart-morris").setViewName("samplepages/chart-morris");
        registry.addViewController("/samples/chart-chartist").setViewName("samplepages/chart-chartist");
        registry.addViewController("/samples/chart-echart").setViewName("samplepages/chart-echart");
        registry.addViewController("/samples/chart-flot").setViewName("samplepages/chart-flot");
        registry.addViewController("/samples/chart-knob").setViewName("samplepages/chart-knob");
        registry.addViewController("/samples/chart-chart-js").setViewName("samplepages/chart-chart-js");
        registry.addViewController("/samples/chart-sparkline").setViewName("samplepages/chart-sparkline");
        registry.addViewController("/samples/chart-extra-chart").setViewName("samplepages/chart-extra-chart");
        registry.addViewController("/samples/chart-peity").setViewName("samplepages/chart-peity");

        registry.addViewController("/samples/pages-error-400").setViewName("samplepages/pages-error-400");
        registry.addViewController("/samples/pages-error-403").setViewName("samplepages/pages-error-403");
        registry.addViewController("/samples/pages-error-404").setViewName("samplepages/pages-error-404");
        registry.addViewController("/samples/pages-error-500").setViewName("samplepages/pages-error-500");
        registry.addViewController("/samples/pages-error-503").setViewName("samplepages/pages-error-503");

        registry.addViewController("/samples/pages-faq").setViewName("samplepages/pages-faq");
        registry.addViewController("/samples/pages-gallery").setViewName("samplepages/pages-gallery");
        registry.addViewController("/samples/pages-pricing").setViewName("samplepages/pages-pricing");
        registry.addViewController("/samples/pages-scroll").setViewName("samplepages/pages-scroll");
        registry.addViewController("/samples/pages-lightbox-popup").setViewName("samplepages/pages-lightbox-popup");
        registry.addViewController("/samples/pages-search-result").setViewName("samplepages/pages-search-result");
        registry.addViewController("/samples/pages-utility-classes").setViewName("samplepages/pages-utility-classes");
        registry.addViewController("/samples/pages-treeview").setViewName("samplepages/pages-treeview");
        registry.addViewController("/samples/pages-invoice").setViewName("samplepages/pages-invoice");
        registry.addViewController("/samples/pages-animation").setViewName("samplepages/pages-animation");
        registry.addViewController("/samples/pages-profile").setViewName("samplepages/pages-profile");
        registry.addViewController("/samples/pages-fix-innersidebar").setViewName("samplepages/pages-fix-innersidebar");
        registry.addViewController("/samples/pages-fix-inner-right-sidebar").setViewName("samplepages/pages-fix-inner-right-sidebar");
        registry.addViewController("/samples/pages-recover-password").setViewName("samplepages/pages-recover-password");
        registry.addViewController("/samples/pages-lockscreen").setViewName("samplepages/pages-lockscreen");
        registry.addViewController("/samples/pages-register2").setViewName("samplepages/pages-register2");
        registry.addViewController("/samples/pages-register").setViewName("samplepages/pages-register");
        registry.addViewController("/samples/pages-login-2").setViewName("samplepages/pages-login-2");
        registry.addViewController("/samples/pages-login").setViewName("samplepages/pages-login");


        registry.addViewController("/samples/app-calendar").setViewName("samplepages/app-calendar");
        registry.addViewController("/samples/app-chat").setViewName("samplepages/app-chat");
        registry.addViewController("/samples/app-ticket").setViewName("samplepages/app-ticket");
        registry.addViewController("/samples/app-contact").setViewName("samplepages/app-contact");
        registry.addViewController("/samples/app-contact2").setViewName("samplepages/app-contact2");
        registry.addViewController("/samples/app-contact-detail").setViewName("samplepages/app-contact-detail");

        registry.addViewController("/samples/app-email").setViewName("samplepages/app-email");
        registry.addViewController("/samples/app-email-detail").setViewName("samplepages/app-email-detail");
        registry.addViewController("/samples/app-compose").setViewName("samplepages/app-compose");

        registry.addViewController("/samples/ui-cards").setViewName("samplepages/ui-cards");
        registry.addViewController("/samples/ui-user-card").setViewName("samplepages/ui-user-card");
        registry.addViewController("/samples/ui-buttons").setViewName("samplepages/ui-buttons");
        registry.addViewController("/samples/ui-modals").setViewName("samplepages/ui-modals");
        registry.addViewController("/samples/ui-tab").setViewName("samplepages/ui-tab");
        registry.addViewController("/samples/ui-tooltip-popover").setViewName("samplepages/ui-tooltip-popover");
        registry.addViewController("/samples/ui-tooltip-stylish").setViewName("samplepages/ui-tooltip-stylish");
        registry.addViewController("/samples/ui-sweetalert").setViewName("samplepages/ui-sweetalert");
        registry.addViewController("/samples/ui-notification").setViewName("samplepages/ui-notification");
        registry.addViewController("/samples/ui-progressbar").setViewName("samplepages/ui-progressbar");
        registry.addViewController("/samples/ui-nestable").setViewName("samplepages/ui-nestable");
        registry.addViewController("/samples/ui-range-slider").setViewName("samplepages/ui-range-slider");
        registry.addViewController("/samples/ui-timeline").setViewName("samplepages/ui-timeline");
        registry.addViewController("/samples/ui-typography").setViewName("samplepages/ui-typography");
        registry.addViewController("/samples/ui-horizontal-timeline").setViewName("samplepages/ui-horizontal-timeline");
        registry.addViewController("/samples/ui-session-timeout").setViewName("samplepages/ui-session-timeout");
        registry.addViewController("/samples/ui-session-ideal-timeout").setViewName("samplepages/ui-session-ideal-timeout");
        registry.addViewController("/samples/ui-bootstrap").setViewName("samplepages/ui-bootstrap");
        registry.addViewController("/samples/ui-breadcrumb").setViewName("samplepages/ui-breadcrumb");
        registry.addViewController("/samples/ui-bootstrap-switch").setViewName("samplepages/ui-bootstrap-switch");
        registry.addViewController("/samples/ui-list-media").setViewName("samplepages/ui-list-media");
        registry.addViewController("/samples/ui-ribbons").setViewName("samplepages/ui-ribbons");
        registry.addViewController("/samples/ui-grid").setViewName("samplepages/ui-grid");
        registry.addViewController("/samples/ui-carousel").setViewName("samplepages/ui-carousel");
        registry.addViewController("/samples/ui-date-paginator").setViewName("samplepages/ui-date-paginator");
        registry.addViewController("/samples/ui-dragable-portlet").setViewName("samplepages/ui-dragable-portlet");
        registry.addViewController("/samples/ui-scrollspy").setViewName("samplepages/ui-scrollspy");
        registry.addViewController("/samples/ui-toasts").setViewName("samplepages/ui-toasts");
        registry.addViewController("/samples/ui-spinner").setViewName("samplepages/ui-spinner");


    }

}
