import React from 'react'

const History = () => {
    return (
        <>
            {/* Rsgsm logo  */}
            <div className="my-4 flex justify-center">
                <img src="https://excise.rajasthan.gov.in/Images/RSGSM.png" className="h-20 sm:h-24 md:28" alt="" />
            </div>

            {/* Heading */}
            <h2 className="my-4 text-2xl font-extrabold leading-none text-gray-600 md:text-3xl dark:text-slate-300 tracking-wide">
                RSGSM Introduction
            </h2>

            {/* paragraph */}

            <p className="my4 text-xs sm:text-sm md:text-base text-justify text-gray-500 tracking-wider dark:text-gray-400">
                <strong>Rajasthan State Ganganagar Sugar Mills Limited (RSGSM)</strong>
                is the oldest Public Sector Undertaking (PSU) of
                <strong> Government of Rajasthan,</strong> having legacy of
                pre-independent India. As a PSU, it has experience of about seven
                decades.
            </p>

            <p className="my-4 text-xs sm:text-sm md:text-base text-justify text-gray-500 tracking-wider dark:text-gray-400">
                <strong>Rajasthan State Ganganagar Sugar Mills Limited (RSGSM) </strong>{" "}
                was initially incorporated in the year 1945 as{" "}
                <strong>“The Bikaner Industrial Corporation Ltd., Bikaner”</strong> in
                private sector and privately run from 1945 to 1952. It was leased to the
                State Government of Rajasthan for a period of two years.
            </p>

            <p className="my-4 text-xs sm:text-sm md:text-base text-justify text-gray-500 tracking-wider dark:text-gray-400">
                The State Government purchased the shares of the managing agents and the
                control of the Company was taken over by the{" "}
                <strong> Government of Rajasthan</strong> w.e.f. 1st July, 1956.
            </p>

            <p className="my-4 text-xs sm:text-sm md:text-base text-justify text-gray-500 tracking-wider dark:text-gray-400">
                Name of the Company was changed as{" "}
                <strong>'The Ganganagar Sugar Mills Limited.' </strong> w.e.f. 21.1.1957
                and it was further changed to{" "}
                <strong>'Rajasthan State Ganganagar Sugar Mills Limited.'</strong>{" "}
                w.e.f. 14th May, 1993.
            </p>

            <div className="flex my-6 flex-row justify-center items-center">
                <img
                    src="https://excise.rajasthan.gov.in/Images/Sugar%20mill.png"
                    alt=""
                    className="sm:h-64"
                />
            </div>

            <p className="my-4 text-xs sm:text-sm md:text-base text-justify text-gray-500 tracking-wider dark:text-gray-400">
                Sugar Factory and Distillery both were always part of Rajasthan State
                Ganganagar Sugar Mills Limited (RSGSM), since its constitution,
                including its Reduction Centres and Bottling Plants. However it has been
                upgraded and expanded over the time.
            </p>

            <div className="flex my-6 flex-row justify-center items-center">
                <img
                    src="https://excise.rajasthan.gov.in/Images/oldsugarmill2.png"
                    alt=""
                    className="sm:h-64"
                />
            </div>

            <p className="my-4 text-xs sm:text-sm md:text-base text-justify text-gray-500 tracking-wider dark:text-gray-400">
                At Present The Head Office Rajasthan State Ganganagar Sugar Mills Limited (RSGSM) is in<strong> Centre of Excellence for Revenue Research and Analytics(CoERRA)     Building,</strong> Third Floor, Near Aranya Bhavan, Jhalana, Jaipur institutional area, Rajasthan, but earlier it was close to Khinvsar House and thereafter Chomu House, Jaipur. Before coming to <strong>CoERRA in 2023,</strong> it was in <strong> Nehru Sahkar Bhawan, Jaipur</strong> for about three decades.
            </p>

            <div className="flex my-6 flex-row justify-center items-center">
                <img
                    src="https://excise.rajasthan.gov.in/Images/oldoffice.png"
                    alt=""
                    className="sm:h-64"
                />
            </div>
        </>
    )
}

export default History
