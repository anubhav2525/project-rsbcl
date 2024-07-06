import React from 'react'
import { rsbclBoardOfDirectors } from "./RsbclBoardOfDirectors"

const RsbclDirectors = () => {
  return (
    <div className='my-2 py-2 px-4 md:px-12 bg-slate-200 dark:bg-slate-900' >
      {/* Breadcrumb */}
      <div className="flex py-1 my-5 text-xs text-gray-700 dark:text-gray-100" aria-label="Breadcrumb">
        <ol className="inline-flex items-center rtl:space-x-reverse">
          <li className="inline-flex items-center">
            <div className="inline-flex items-center text-sm font-medium text-gray-700 hover:text-blue-600 dark:text-gray-400 dark:hover:text-white">
              About
            </div>
          </li>
          <li>
            <div className="flex items-center">
              <svg className="rtl:rotate-180 block w-3 h-3 mx-1 text-gray-400 " aria-hidden="true" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 6 10">
                <path stroke="currentColor" strokeLinecap="round" strokeLinejoin="round" strokeWidth="2" d="m1 9 4-4-4-4" />
              </svg>
              <div className="ms-1 text-sm font-medium text-gray-700 hover:text-blue-600 md:ms-2 dark:text-gray-400 dark:hover:text-white">RSBCL</div>
            </div>
          </li>
          <li aria-current="page">
            <div className="flex items-center">
              <svg className="rtl:rotate-180  w-3 h-3 mx-1 text-gray-400" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 6 10">
                <path stroke="currentColor" strokeLinecap="round" strokeLinejoin="round" strokeWidth="2" d="m1 9 4-4-4-4" />
              </svg>
              <span className="ms-1 text-sm font-medium text-gray-500 md:ms-2 dark:text-gray-300">Board of Directors</span>
            </div>
          </li>
        </ol>
      </div>

      {/* Heading  */}
      <h2 className="mb-4 text-2xl font-extrabold leading-none text-gray-600 md:text-3xl dark:text-slate-300 tracking-wide">RSBCL Board of Directors</h2>

      {/* table  */}
      <div className='my-4 bg-slate-300 dark:bg-slate-800 px-2 rounded sm:px-4 md:px-8 py-2'>
        {/* table here  */}
        <div className="relative rounded overflow-x-auto shadow-md sm:rounded-lg">
          <div className="relative overflow-x-auto shadow-md sm:rounded-lg">
            <table className="w-full text-sm text-left rtl:text-right text-gray-600 dark:text-gray-300">
              <thead className="text-xs text-white uppercase bg-gray-400 dark:bg-gray-400 dark:text-white">
                <tr>
                  <th scope="col" className="px-6 py-3">
                    S. No.
                  </th>
                  <th scope="col" className="px-6 py-3">
                    Name
                  </th>
                  <th scope="col" className="px-6 py-3">
                    Address
                  </th>
                  <th scope="col" className="px-6 py-3">
                    Designation
                  </th>
                  <th scope="col" className="px-6 py-3">
                    Phone No.
                  </th>
                </tr>
              </thead>
              <tbody>
                {
                  rsbclBoardOfDirectors.map((items, index) => {
                    return (
                      <tr key={index} className="bg-white tracking-wide border-b dark:bg-gray-600 dark:border-gray-700">
                        <td className="px-6 py-4">
                          {items.sN}
                        </td>
                        <th scope="row" className="px-6 py-4 font-medium text-gray-900 whitespace-nowrap dark:text-white">
                          {items.name}
                        </th>
                        <td className="px-6 py-4">
                          {items.address}
                        </td>
                        <td className="px-6 py-4">
                          {items.designation}
                        </td>
                        <td className="px-6 py-4">
                          {items.phoneNo}
                        </td>
                      </tr>
                    )
                  })
                }


              </tbody>
            </table>
          </div>

        </div>

      </div>
    </div >
  )
}

export default RsbclDirectors
