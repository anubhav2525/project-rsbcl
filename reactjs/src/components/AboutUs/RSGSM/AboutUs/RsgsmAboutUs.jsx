import React from "react";
import BreadCrumb from "./parts/BreadCrumb"
import History from "./parts/History";
import Objectives from "./parts/Objectives";
import Management from "./parts/Management";
import OrganisationalStructure from "./parts/OrganisationalStructure";
import Work from "./parts/Work";
import TurnOverProfit from "./parts/TurnOverProfit";
import RajasthanHeritageLiquor from "./parts/RajasthanHeritageLiquor";
import CSRActivities from "./parts/CSRActivities";
import TechnologicalEnhancement from "./parts/TechnologicalEnhancement";
import FuturePlans from "./parts/FuturePlans";

const RsgsmAboutUs = () => {
    return (
        <div className="my-2 py-2 px-4 md:px-12 bg-slate-200 dark:bg-slate-900">
            {/* Breadcrumb */}
            <BreadCrumb />

            {/* Heading  */}
            <History />

            {/* Objectives */}
            <Objectives />

            {/* Management  */}
            <Management />

            {/* organisational structure  */}
            <OrganisationalStructure />

            {/* work */}
            <Work />

            {/* Rajasthan Heritage Liquor */}
            <RajasthanHeritageLiquor />

            {/* turn over and profit */}
            <TurnOverProfit />

            {/* CSRActivities */}
            <CSRActivities />

            {/* Technological Enhancement */}
            <TechnologicalEnhancement />

            {/* Future Plans */}
            <FuturePlans />
        </div >
    );
};

export default RsgsmAboutUs;
