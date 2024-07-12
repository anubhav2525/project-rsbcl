import React, { useState, useEffect } from 'react'
import axios from 'axios';

const SugarCaneTable = () => {
  // api
  const [sugarcane, setSugarCane] = useState([]);
  useEffect(() => {
    axios.get("/api/v1/about-rsgsm/sugar-cane-division") // Use the proxied URL
      .then((res) => {
        setSugarCane(res.data);
        console.log('Response data:', res.data); // Log the response data
      })
      .catch((error) => {
        console.error('Error:', error); // Log any errors
      });
  }, []);

  return (
    <>
      {/* sugar cane table here  */}
      <div className="relative rounded overflow-x-auto shadow-md sm:rounded-lg" >
        <div className="relative overflow-x-auto shadow-md sm:rounded-lg">
          <table className="w-full text-left rtl:text-right text-gray-600 dark:text-gray-300">
            <caption className=" text-center py-3 font-semibold text-gray-900 bg-white dark:text-white dark:bg-gray-800">
              <p className=" text-xs sm:text-sm text-gray-500 dark:text-gray-400">
                Sugar Cane Crushing, Sugar Production, Rectified Spirit
                Production & Electricity Generation
              </p>
            </caption>
            <thead className="text-xs text-white uppercase bg-gray-400 dark:bg-gray-400 dark:text-white">
              <tr>
                <th scope="col" className="px-2 py-3 border-r border-white">
                  Year
                </th>
                <th scope="col" className="px-2 py-3 border-r border-white">
                  Cane Crushed (Lac Qtls.)
                </th>
                <th scope="col" className="px-2 py-3 border-r border-white">
                  Total no. of days in Crushing Season
                </th>
                <th scope="col" className="px-2 py-3 border-r border-white">
                  Recovery %
                </th>
                <th scope="col" className="px-2 py-3 border-r border-white">
                  Sugar Production (Lac Qtls.)
                </th>
                <th scope="col" className="px-2 py-3 border-r border-white">
                  Electricity Export (units)
                </th>
                <th scope="col" className="px-2 py-3 border-r border-white">
                  Rectified Spirit Production (Lac BL)
                </th>
              </tr>
            </thead>
            <tbody>
              {sugarcane.map((items, index) => {
                return (
                  <tr
                    key={index}
                    className="bg-white text-xs sm:text-sm text-center tracking-wide border-b dark:bg-gray-600 dark:border-gray-700"
                  >
                    <td className="px-2 py-3 border-x border-slate-300">{items.year}</td>
                    <td className="px-2 py-3 border-x border-slate-300">{items.caneCrushed}</td>
                    <td className="px-2 py-3 border-x border-slate-300">{items.days}</td>
                    <td className="px-4 py-3 border-x border-slate-300">{items.recovery}</td>
                    <td className="px-2 py-3 border-x border-slate-300">{items.sugarProduction}</td>
                    <td className="px-2 py-3 border-x border-slate-300">{items.electricityExport}</td>
                    <td className="px-2 py-3 border-x border-slate-300">{items.rectifiedSpirit}</td>
                  </tr>
                );
              })}
            </tbody>
          </table>
        </div>
      </div >
    </>
  )
}

export default SugarCaneTable
