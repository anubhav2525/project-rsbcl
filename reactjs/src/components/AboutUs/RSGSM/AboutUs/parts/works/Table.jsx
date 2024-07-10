import React from 'react'
import SugarCaneTable from './sugarDivision/SugarCaneTable';
import FinancialTable from './sugarDivision/FinancialTable';
import ProfitLossTable from './sugarDivision/ProfitLossTable';

const Table = () => {
    return (
        <div className="my-4 bg-slate-300 dark:bg-slate-800 px-2 rounded sm:px-4  py-2" >
            {/* sugar cane table */}
            <SugarCaneTable />
            <div className="grid md:grid-cols-2 gap-4 mt-4">
                {/* financial table  */}
                <FinancialTable />

                {/* profit loss table  */}
                <ProfitLossTable />
            </div>
        </div >
    )
}

export default Table
