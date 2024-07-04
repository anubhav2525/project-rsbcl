import React from 'react'

const ExciseOrganisationSetup = () => {

  const data = [{
    id: 1,
    index1: "Joint Excise Commissioner, EPF",
    index2: "Additional Excise Commissioner (Policy)",
    index3: "Senior A.O.",
    index4: "D.L.R.",
    index5: "Annalist cum Programmer",
    index6: " Assistant Chemical Examiner"
  },
  {
    id: 2,
    index1: "Deputy Commissioner, EPF",
    index2: "Additional Excise Commissioner (Legal)",
    index3: "Account Officer",
    index4: " Sr. Legal Officer",
    index5: " Programmer",
    index6: ""
  }, {
    id: 3,
    index1: "",
    index2: "Dy. Commissioner (H.Q.)",
    index3: "",
    index4: "",
    index5: "",
    index6: ""
  }]

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
              <div className="ms-1 text-sm font-medium text-gray-700 hover:text-blue-600 md:ms-2 dark:text-gray-400 dark:hover:text-white">Excise</div>
            </div>
          </li>
          <li aria-current="page">
            <div className="flex items-center">
              <svg className="rtl:rotate-180  w-3 h-3 mx-1 text-gray-400" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 6 10">
                <path stroke="currentColor" strokeLinecap="round" strokeLinejoin="round" strokeWidth="2" d="m1 9 4-4-4-4" />
              </svg>
              <span className="ms-1 text-sm font-medium text-gray-500 md:ms-2 dark:text-gray-300">Organisation Setup</span>
            </div>
          </li>
        </ol>
      </div>

      {/* Heading  */}
      <h2 className="mb-4 text-2xl font-extrabold leading-none text-gray-600 md:text-3xl dark:text-slate-300 tracking-wide">Excise Organisation Setup</h2>

      {/* table  */}
      <div className='my-4 bg-slate-300 dark:bg-slate-800 px-2 rounded sm:px-4 md:px-8 py-2'>

        <p className="tracking-widest font-medium text-gray-600 text-sm md:text-lg my-3 sm:text-center dark:text-gray-00">Excise Commissioner & Ex-Officio Prohibition Commissioner cum M.D., R.S.B.C.L. Rajasthan
        </p>
        {/* table here  */}
        <div class="relative rounded overflow-x-auto shadow-md sm:rounded-lg">
          <div class="relative overflow-x-auto shadow-md sm:rounded-lg">
            <table class="w-full text-sm text-left rtl:text-right text-gray-500 dark:text-gray-400">
              <thead class="text-xs text-gray-700 uppercase bg-gray-50 dark:bg-gray-700 dark:text-gray-400">
                <tr>
                  <th scope="col" class="px-6 py-3">
                    Additional Excise Commissioner (EPF)IPS
                  </th>
                  <th scope="col" class="px-6 py-3">
                    Additional Excise Commissioner (Adm)
                  </th>
                  <th scope="col" class="px-6 py-3">
                    F.A.
                  </th>
                  <th scope="col" class="px-6 py-3">
                    Jt. L.R.
                  </th>
                  <th scope="col" class="px-6 py-3">
                    System Annalist
                  </th>
                  <th scope="col" class="px-6 py-3">
                    Chemical Examiner
                  </th>
                </tr>
              </thead>
              <tbody>
                {
                  data.map((items, index) => {
                    return (
                      <tr key={index} className="bg-white border-b dark:bg-gray-800 dark:border-gray-700">
                        <td class="px-6 py-4">
                          {items.index1}
                        </td>
                        <td class="px-6 py-4">
                          {items.index2}
                        </td>
                        <td class="px-6 py-4">
                          {items.index3}
                        </td>
                        <td class="px-6 py-4">
                          {items.index4}
                        </td>
                        <td class="px-6 py-4">
                          {items.index5}
                        </td>
                        <td class="px-6 py-4">
                          {items.index6}
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

export default ExciseOrganisationSetup
