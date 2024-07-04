import React from 'react'

const ContactUs = () => {
    return (
        <div className='my-2 py-2 px-4 md:px-12 bg-slate-200 dark:bg-slate-900' >
            {/* Heading  */}
            <h2 className="mb-4 text-2xl font-extrabold leading-none text-gray-600 md:text-3xl dark:text-slate-300 tracking-wide">Contact Us</h2>

            {/* Lists  */}
            <div className='my-4  bg-slate-300 dark:bg-slate-800 px-2 rounded sm:px-4 md:px-8 py-2 '>
                <div className='grid  text-sm sm:text-base  sm:grid-cols-2 gap-10 md:gap-16 p-4'>
                    <div className='tracking-wider text-gray-500 md:text-lg dark:text-gray-400'>
                        <div>
                            <div>OFFICE OF THE EXCISE COMMISSIONER, RAJASTHAN 2, Gumaniawala Panchwati UDAIPUR- 313001 INDIA</div>
                            <div>Telephones: </div>
                            <div>
                                Excise Commissioner: +91.0294.2524911 Addl.
                            </div>
                            <div>
                                Commissioner (ADM): +91.0294.2527074 Addl.
                            </div>
                            <div>
                                Commissioner (EXCISE): +91.0294.2523124
                            </div>
                        </div>
                    </div>

                    <div className='tracking-wider text-gray-500 md:text-lg dark:text-gray-400'>
                        <div>RAJASTHAN STATE BEVERAGES CORPORATION LIMITED (A Government of Rajasthan Undertaking) 5th Floor, O/o COERRA, Plot No - 2, Jhalana Bypass, Jaipur - 302004</div>
                        <div>Phones: + 91-141-2744239</div>
                        <div>Fax- + 91-141-2744237</div>
                    </div>

                    <div className='tracking-wider text-gray-500 md:text-lg dark:text-gray-400'>
                        <div>Rajasthan State Ganganagar Sugar Mills Ltd. (RSGSM) COERRA, 3rd floor,opp. aranya bhawan,Jhalana Doongri, Jaipur, Rajasthan 302004</div>
                        <div>Phone No. :- </div>
                        <div>EPABX : 2740246, 2740040, 2740068</div>
                        <div>FAX No. :- 0141-2740676</div>
                    </div>

                    <div className='tracking-wider text-gray-500 md:text-lg dark:text-gray-400'>
                        <div>Sugar Factory, Sriganganagar</div>
                        <div>Fax No. 01501-248016, Kanta:- 01501-248010, Gate:-01501-248011</div>
                    </div>
                </div>
            </div>
        </div>

    )
}

export default ContactUs
