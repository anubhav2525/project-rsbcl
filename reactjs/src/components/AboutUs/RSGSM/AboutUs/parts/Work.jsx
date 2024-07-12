import React from 'react'
import SugarDivision from './works/SugarDivision';
import Table from './works/Table';
import LiquorDivision from './works/LiquorDivision';

const Work = () => {
    return (
        <div>
            <h2 className="my-4 text-lg font-semibold text-gray-900 dark:text-white">
                Works :
            </h2>

            <div className="my-4 text-xs sm:text-sm md:text-base text-justify text-gray-500 tracking-wider dark:text-gray-400 px-1 space-y-2">
                {/* sugar division  */}
                <div>Presently, the company has two divisions:-</div>
                {/* sugar division  */}
                <SugarDivision />

                {/* sugar division table  */}
                <Table />
                <div className="my-4">
                    <div>The all three new products-</div>
                    <ul className="list-inside list-disc px-4">
                        <li>Brown Sugar(Gudia shakkar)</li>
                        <li>Jaggery</li>
                        <li>Jaggery Powder</li>
                    </ul>
                    <div>
                        are made in traditional process, without adding any chemical.
                    </div>
                </div>


                <div className="flex justify-center my-6">
                    <img
                        src="https://excise.rajasthan.gov.in/Images/brown%20sugar.png"
                        alt=""
                        className="sm:h-64"
                    />
                </div>

                {/* Liqiuor division */}
                <LiquorDivision />
            </div>
        </div>
    )
}

export default Work
