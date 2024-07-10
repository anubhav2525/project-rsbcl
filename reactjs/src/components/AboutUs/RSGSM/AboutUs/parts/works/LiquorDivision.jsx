import React from 'react'
import ManufacturedLiquors from './liquorDivision/ManufacturedLiquors'
import ReductionCenterTable from './liquorDivision/ReductionCenterTable'
import SalesTable from './liquorDivision/SalesTable'

const LiquorDivision = () => {
    return (
        <>
            <div className="my-4 text-justify px-4">
                <strong>2. Liquor Division:- </strong> This Divisions mainly looks
                after production of Liquor. Apart from this, wine production is also
                introduced recently. Hand Sanitizers production were also introduced
                during critical period of Covid-19.
            </div>
            <div className="my-6 flex justify-center">
                <img
                    src="https://excise.rajasthan.gov.in/Images/hand%20Sanitizer.png"
                    alt=""
                    className="sm:h-64"
                />
            </div>
            <div className="my-4 py-4">
                Presently there are 17 Reduction Centres & 85 Depots across Rajasthan.
                The RSGSM manufactures its liquors mainly in 3 categories-
            </div>

            {/* RSGSM Manufactured Liquors table*/}
            <ManufacturedLiquors />

            <div className="my-4 py-2 text-justify">
                Raj Mahua was also introduced on 19th October, 2021 by RSGSM as new
                brand, using Mahua of Udaipur Division, as per guidelines of Excise
                Policy of 2021-22.
            </div>

            <div className="my-4 py-2 text-justify">
                <div>
                    All the brands were available in the packings of 12, 24 and 48 case
                    of quarts, pints and nips respectively.
                </div>
                <div>
                    Starting from Sriganganagar, Rajasthan State Ganganagar Sugar Mills
                    Limited (RSGSM) made its presence in pan Rajasthan, in short span of
                    time.
                </div>
            </div>

            <div className="my-6 flex justify-center">
                <img
                    src="https://excise.rajasthan.gov.in/Images/Ganganagar.png"
                    alt=""
                    className="sm:h-80"
                />
            </div>

            <div className="my-4 px-4">
                After expansion of upto 20 Reduction Centres (RCs) and 99 Depots, it
                has reorganized its RC &Depots to manage its economy of scale. At
                Present, Country Liquor (CL) and Rajasthan Made Liquor (RML) are
                manufactured through 17 Reduction Centres; Rajasthan Heritage Liquor
                (RHL) is manufactured in the Jaipur State Distillery (JSD). All are
                sold through 85 Depots.
            </div>

            {/* Reduction center table  */}
            <ReductionCenterTable />

            <div className="space-y-2 my-4">
                <div>
                    RSGSM is also selling the Country Liquor (CL) and Rajasthan Made
                    Liquor (RML) of Private Supplier through same Depots.
                </div>
                <div>
                    Sale of Country Liquor (CL) and Rajasthan Made Liquor (RML) in last
                    few years is as follows-
                </div>
            </div>

            {/* RSGSM- Sale of Country Liquor (CL) and Rajasthan Made Liquor (RML) table */}
            {/* table  */}
            <SalesTable />

            <div className="my-4 px-4">
                RSGSM is also selling the Country Liquor (CL) and Rajasthan Made
                Liquor (RML) of Private Supplier through same Depots.
            </div>

        </>
    )
}

export default LiquorDivision
