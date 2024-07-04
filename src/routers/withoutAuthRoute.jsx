import React from 'react'
import { createBrowserRouter } from 'react-router-dom'

// layouts
import WithoutNav from "../layouts/WithoutNav"
import WithNav from "../layouts/WithNav"

// contact us
import ContactUs from "../components/ContactUs/ContactUs"

// mobile app
import MobileApp from "../components/MobileApp/MobileApp"

// home
import Home from "../components/Home/Home"

// Login
import ExciseLogin from "../components/Login/Excise/ExciseLogin"
import RsbclLogin from "../components/Login/Rsbcl/RsbclLogin"
import RsgsmLogin from "../components/Login/Rsgsm/RsgsmLogin"

// directory excise
import DirectoryExciseOffice from "../components/Directory/Excise/DirectoryExciseOffice/DirectoryExciseOffice"

// directory rsgsm
import RsgsmDepots from "../components/Directory/RSGSM/Depots/RsgsmDepots"
import RsgsmHeadOffice from "../components/Directory/RSGSM/HeadOffice/RsgsmHeadOffice"
import RsgsmReductionCenter from "../components/Directory/RSGSM/ReductionCenter/RsgsmReductionCenter"
import RsgsmSugarMill from "../components/Directory/RSGSM/SugarMill/RsgsmSugarMill"

// directory rsbcl
import RsbclDepots from "../components/Directory/RSBCL/Depots/RsbclDepots"
import RsbclHeadOffice from "../components/Directory/RSBCL/HeadOffice/RsbclHeadOffice"

// about us excise
import ExciseIntroduction from "../components/AboutUs/Excise/Introduction/ExciseIntroduction"
import ExciseOrganisationSetup from '../components/AboutUs/Excise/OrganisationSetup/ExciseOrganisationSetup'

// about us rsbcl
import RsbclDirectors from "../components/AboutUs/RSBCL/Directors/RsbclDirectors"
import RsbclIntroduction from "../components/AboutUs/RSBCL/Introduction/RsbclIntroduction"
import RsbclMemorandom from "../components/AboutUs/RSBCL/Memorandom/RsbclMemorandom"
import RsbclOrganizationSetup from "../components/AboutUs/RSBCL/OrganisationSetup/RsbclOrganizationSetup"

// about us rsgsm
import RsgsmAboutUs from "../components/AboutUs/RSGSM/AboutUs/RsgsmAboutUs"


// requirement
import RequirementExcise from "../components/Requirement/Excide/RequirementExcise"
import RequirementRsbcl from "../components/Requirement/RSBCL/RequirementRsbcl"
import RequirementRsgsm from "../components/Requirement/RSGSM/RequirementRsgsm"

// administrator dashboard
import AdministatorDashboard from "../components/AdminstatorDashboard/AdministatorDashboard"

// AnalyticDashboard
import AnalyticDashboard from "../components/AnalyticDashboard/AnalyticDashboard"

// ScreenReaderAccess
import ScreenReaderAccess from "../components/ScreenReaderAccess/ScreenReaderAccess"

export const withoutAuthRoute = createBrowserRouter([{
  path: "/",
  element: <WithNav />,
  children: [
    // Home 
    {
      path: "",
      element: <Home />

    },
    // ScreenReaderAccess
    {
      path: "screen-reader-access",
      element: <ScreenReaderAccess />
    },
    // AnalyticDashboard
    {
      path: "analytic-dashboard",
      element: <AnalyticDashboard />
    },

    //AdministatorDashboard
    {
      path: "administator-dashboard",
      element: <AdministatorDashboard />
    },

    // Requirement Excise
    {
      path: "requirement-excise",
      element: <RequirementExcise />
    },
    // Requirement Rsbcl
    {
      path: "requirement-rsbcl",
      element: <RequirementRsbcl />
    },
    // Requirement Rsgsm
    {
      path: "requirement-rsgsm",
      element: <RequirementRsgsm />
    },
    // about excise 
    {
      path: "about-excise-introduction",
      element: <ExciseIntroduction />
    },
    {
      path: "about-excise-organization",
      element: <ExciseOrganisationSetup />
    },
    // about RSBCL
    {
      path: "about-rsbcl-introduction",
      element: <RsbclIntroduction />
    },
    {
      path: "about-rsbcl-directors",
      element: <RsbclDirectors />
    },
    {
      path: "about-rsbcl-organization",
      element: <RsbclOrganizationSetup />
    },
    {
      path: "about-rsbcl-memorandom",
      element: <RsbclMemorandom />
    },
    // about RSGSM
    {
      path: "about-rsgsm",
      element: <RsgsmAboutUs />
    },

    // directory excise

    // directory excise office
    {
      path: "directory-excise/:offices",
      element: <DirectoryExciseOffice />
    },


    // directory rsgsm
    // directory rsgsm head
    {
      path: "directory-rsgsm-head-office",
      element: <RsgsmHeadOffice />
    },
    // directory rsgsm depots
    {
      path: "directory-rsgsm-depots",
      element: <RsgsmDepots />
    },
    // directory rsgsm reduction center
    {
      path: "directory-rsgsm-reduction-center",
      element: <RsgsmReductionCenter />
    },
    // directory rsgsm sugar mill
    {
      path: "directory-rsgsm-sugar-mill",
      element: <RsgsmSugarMill />
    },

    // directory rsbcl
    // directory rsbcl depots
    {
      path: "directory-rsbcl-depots",
      element: <RsbclDepots />
    },
    // directory rsbcl depots
    {
      path: "directory-rsbcl-head-office",
      element: <RsbclHeadOffice />
    },

    // mobile app
    {
      path: "mobile-app",
      element: <MobileApp />
    },

    // contact-us
    {
      path: "contact-us",
      element: <ContactUs />
    },

    // Login 
    // login excise
    {
      path: "excise-login",
      element: <ExciseLogin />
    },
    // login rsbcl
    {
      path: "rsbcl-login",
      element: <RsbclLogin />
    },
    // login rsgsm
    {
      path: "rsgsm-login",
      element: <RsgsmLogin />
    },

  ]
}, {
  path: "/something",
  element: <WithoutNav />,
  children: [
    {
      path: "",
      element: <Home />
    }
  ]
}

])
