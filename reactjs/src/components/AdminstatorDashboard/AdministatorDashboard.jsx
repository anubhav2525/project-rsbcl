import React, { act, useState } from 'react'
import Sales from './pages/Sales';
import Revenue from "./pages/Revenue"
import ShopSale from './pages/ShopSale';
import Production from './pages/Production';
import DepotStock from "./pages/DepotStock";
import InformationApp from "./pages/InformationApp"
import LiquorSupplyStatus from "./pages/LiquorSupplyStatus";
import VehicleStatus from './pages/VehicleStatus';
import GRNDefenceStatus from './pages/GRNDefenceStatus';

const AdministatorDashboard = () => {
  const [activeContainer, setActiveContainer] = useState(0);

  const handleButtonClick = (index) => {
    setActiveContainer(index);
  };

  return (
    <div className='my-2 py-2 px-4 md:px-12 bg-slate-200 dark:bg-slate-900' >
      {/* Breadcrumb */}
      <div className="flex py-1 my-2 text-xs text-gray-700 dark:text-gray-100" aria-label="Breadcrumb">
        <ol className="inline-flex items-center rtl:space-x-reverse">
          <li className="inline-flex items-center">
            <div className="inline-flex items-center text-sm font-medium text-gray-700 hover:text-blue-600 dark:text-gray-400 dark:hover:text-white">
              Home
            </div>
          </li>
          <li>
            <div className="flex items-center">
              <svg className="rtl:rotate-180 block w-3 h-3 mx-1 text-gray-400 " aria-hidden="true" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 6 10">
                <path stroke="currentColor" strokeLinecap="round" strokeLinejoin="round" strokeWidth="2" d="m1 9 4-4-4-4" />
              </svg>
              <div className="ms-1 text-sm font-medium text-gray-700 hover:text-blue-600 md:ms-2 dark:text-gray-400 dark:hover:text-white">Administration Dashboard</div>
            </div>
          </li>
        </ol>
      </div>

      {/* Heading  */}
      {/* <h2 className="mb-4 text-center text-2xl font-extrabold leading-none text-gray-600 md:text-3xl dark:text-slate-300 tracking-wide">Administration Dashboard</h2> */}

      {/* category */}
      <div className='my-4 w-full bg-slate-300 dark:bg-slate-800 px-2 rounded sm:px-4 md:px-8 py-2'>
        <div className='grid grid-cols-3 text-xs s sm:grid-cols-3 gap-4 md:grid-cols-5 lg:grid-cols-6'>
          <button type="button" onClick={() => handleButtonClick(0)} className="text-white bg-blue-700 hover:bg-blue-800 font-medium rounded-lg  px-5 py-2.5 dark:bg-blue-600 dark:hover:bg-blue-700">Sales</button>
          <button type="button" onClick={() => handleButtonClick(1)} className="text-white bg-blue-700 hover:bg-blue-800 font-medium rounded-lg  px-5 py-2.5 dark:bg-blue-600 dark:hover:bg-blue-700">Revenue</button>
          <button type="button" onClick={() => handleButtonClick(2)} className="text-white bg-blue-700 hover:bg-blue-800 font-medium rounded-lg  px-5 py-2.5 dark:bg-blue-600 dark:hover:bg-blue-700">Production</button>
          <button type="button" onClick={() => handleButtonClick(3)} className="text-white bg-blue-700 hover:bg-blue-800 font-medium rounded-lg  px-5 py-2.5 dark:bg-blue-600 dark:hover:bg-blue-700">Shop Sale</button>
          <button type="button" onClick={() => handleButtonClick(4)} className="text-white bg-blue-700 hover:bg-blue-800 font-medium rounded-lg  px-5 py-2.5 dark:bg-blue-600 dark:hover:bg-blue-700">Liquor Supply Status</button>
          <button type="button" onClick={() => handleButtonClick(5)} className="text-white bg-blue-700 hover:bg-blue-800 font-medium rounded-lg  px-5 py-2.5 dark:bg-blue-600 dark:hover:bg-blue-700">Information App</button>
          <button type="button" onClick={() => handleButtonClick(6)} className="text-white bg-blue-700 hover:bg-blue-800 font-medium rounded-lg  px-5 py-2.5 dark:bg-blue-600 dark:hover:bg-blue-700">Vehicle Status</button>
          <button type="button" onClick={() => handleButtonClick(7)} className="text-white bg-blue-700 hover:bg-blue-800 font-medium rounded-lg  px-5 py-2.5 dark:bg-blue-600 dark:hover:bg-blue-700">GRN Defence Status</button>
          <button type="button" onClick={() => handleButtonClick(8)} className="text-white bg-blue-700 hover:bg-blue-800 font-medium rounded-lg  px-5 py-2.5 dark:bg-blue-600 dark:hover:bg-blue-700">Depot Stock</button>
        </div>
      </div>

      <div>
        {/* Sales */}
        {activeContainer === 0 && (<Sales />)}
        {/* Revenue */}
        {activeContainer === 1 && (<Revenue />)}
        {/* Production */}
        {activeContainer === 2 && (<Production />)}
        {/* Shop Sale  */}
        {activeContainer === 3 && (<ShopSale />)}
        {/* Liquor Supply Status */}
        {activeContainer === 4 && (<LiquorSupplyStatus />)}
        {/* Information App */}
        {activeContainer === 5 && (<InformationApp />)}
        {/* Vehicle Status */}
        {activeContainer === 6 && (<VehicleStatus />)}
        {/* GRN Defence Status */}
        {activeContainer === 7 && (<GRNDefenceStatus />)}
        {/* Depot Stock */}
        {activeContainer === 8 && (<DepotStock />)}
      </div>
    </div>
  )
}

export default AdministatorDashboard
