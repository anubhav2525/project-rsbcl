import React from 'react'
import RHLBrand from './RajasthanHeritageLiquor/RHLBrand'

const RajasthanHeritageLiquor = () => {
    return (
        <div className='my-6 '>
            {/* Rajasthan Heritage Liquor */}
            <h2 className="my-2 text-lg font-semibold text-gray-900 dark:text-white">
                Rajasthan Heritage Liquor :
            </h2>

            <p className="my-4 text-xs sm:text-sm md:text-base text-justify text-gray-500 tracking-wider dark:text-gray-400 px-3">
                Rajasthan State Ganganagar Sugar Mills Limited (RSGSM) is having
                legacy of pre-independent India and it has experience of more seven
                decades. It has <strong> Jaipur State</strong> Distillery in Jhotwara,
                Jaipur, which was established in 1927, under princely estate of Jaipur
                and <strong>Mandore Distillery</strong> in Mandore, Jodhpur, which was
                established in 1924, under princely estate of Jodhpur.
            </p>

            <p className="my-4 text-xs sm:text-sm md:text-base text-justify text-gray-500 tracking-wider dark:text-gray-400 px-3">
                Since its formation, Rajasthan State Ganganagar Sugar Mills Limited
                (RSGSM) had molasses based distillery in SriGanganagar. On account of
                growing demand, Four More distilleries were acquired, one each at
                Ajmer (1957), Mandore (1957), Atru (1961) and Pratapgarh (1963). The
                distillery at Mandore was closed in May 1968 on account of sharabbandi
                movement and that at Pratapgarh was closed in March, 1973 being a
                small and uneconomic unit. Subsequently only the{" "}
                <strong>Jaipur State Distillery</strong> in Jhotwara, Jaipur, remained
                in work, since other than Rajasthan Heritage Liquor (RHL), all has
                shifted to Rectified Spirit (RS) or Extra Neutral Alcohol (ENA).
                However some of the original Pot stills and Vats, including wooden
                barrels are in the company, as its valuable asset.
            </p>

            <div className="my-6 flex justify-center">
                <img
                    src="https://excise.rajasthan.gov.in/Images/Distillery.png"
                    alt=""
                    className="sm:h-64"
                />
            </div>

            <p className="my-4 text-xs sm:text-sm md:text-base text-justify text-gray-500 tracking-wider dark:text-gray-400 px-3">
                RSGSM has set forth to boost the heritage of Rajasthan, India by
                resuscitating the Heritage Liquor, which was consumed and composed by
                herbal recipes since ancient times. The ingredients as recipe of
                liquor have been taken from Regal Legacy, which had been traditionally
                owned and used by imperial families of Rajasthan.
            </p>

            <p className="my-4 text-xs sm:text-sm md:text-base text-justify text-gray-500 tracking-wider dark:text-gray-400 px-3">
                The Rajasthan Royal Heritage Liquor is a separate and unique segment
                of alcoholic beverages produced by RSGSM, which is produced in a
                traditional manner and process, as defined for Heritage Liquor, from
                soaking to distillation. At present six brands are produced by RSGSM
                in its own Distillery, established from Estate Times. These Brands are
                further categorised based on the number of of herbs and spices used as
                recipes, which are carefully picked and chosen with its quality norms.
            </p>
            <div className="my-4 px-4">
                <div className='my-4 text-xs sm:text-sm md:text-base text-justify text-gray-500 tracking-wider dark:text-gray-400 font-extrabold'>The Details of the RHL Brands are as follows:</div>

                {/* RHL Brand Table  */}
                <RHLBrand />

                <p className="my-4 text-xs sm:text-sm md:text-base text-justify text-gray-500 tracking-wider dark:text-gray-400 px-3">
                    All the brands of Rajasthan Heritage Liquor (RHL) are supplied in its unique packaging, for which the theme and design are chosen as per the legacy of Rajasthan, from bottle to label and overall packing. Currently, all brands are having packaging of same quantity, but it may be provided in other sizes as per requirement of franchisee and policy of RSGSM.</p>

                <p className="my-4 text-xs sm:text-sm md:text-base text-justify text-gray-500 tracking-wider dark:text-gray-400 px-3">
                    Apart from Rajasthan Royal Heritage Liquor, RSGSM is also planning to introduce Folk Heritage Liquor, for which Sitafal (Custard Apple), Narangi (Orange), Kinnu (Kinnow), Khajoor (Dates), Mahua (Madhooka), Madhu (Honey), Aparaajita (ClitoriaTernatea) are planned under Brand Name of "Raajasi, The Royal".
                </p>

                <p className="my-4 text-xs sm:text-sm md:text-base text-justify text-gray-500 tracking-wider dark:text-gray-400 px-3 font-semibold">Introduced ‘Mahuwa Liquor’, based on mahuwa flowers which was procured from Tribal Zone of Udaipur, Dungarpur through “RAJIVIKA MISSION” and financial amount paid to Tribal women in cluster group through Bank Account.</p>

                <p className="my-4 text-xs sm:text-sm md:text-base text-justify text-gray-500 tracking-wider dark:text-gray-400 px-3">
                    Rajasthan Wines Rajasthan State Ganganagar Sugar Mills Limited (RSGSM) has its own winery, in its Jhotwara Reduction Centre, Jaipur, erstwhile Jaipur State Distillery (established in 1927) premise. Rajwine is the prominent brand of its wine. At present, It has is producing its Guava Wines, from the famous guavas of Sawai Madhopur. Sitafal (Custard Apple), Narangi (Orange), Kinnu (Kinnow), Khajoor (Dates), are some of the other wines, which are in pipeline.
                </p>
            </div>
        </div>
    )
}

export default RajasthanHeritageLiquor
