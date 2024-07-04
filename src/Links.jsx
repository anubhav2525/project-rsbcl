import React from 'react'
import { Link } from 'react-router-dom'
const Links = () => {
    return (
        <div className='flex flex-col gap-4 justify-center items-center text-gray-800 dark:text-white'>
            <Link to='/'>Home</Link>
            <Link to='/screen-reader-access'>screen-reader-access</Link>
            <Link to='/analytic-dashboard'>analytic-dashboard</Link>
            <Link to='/administator-dashboard'>administator-dashboard</Link>
            <Link to='/requirement-excise'>requirement-excise</Link>
            <Link to='/requirement-rsbcl'>requirement-rsbcl</Link>
            <Link to='/requirement-rsgsm'>requirement-rsgsm</Link>
            <Link to='/about-excise-introduction'>about-excise-introduction</Link>
            <Link to='/about-excise-organization'>about-excise-organization</Link>
            <Link to='/about-rsbcl-introduction'>about-rsbcl-introduction</Link>
            <Link to='/about-rsbcl-directors'>about-rsbcl-directors</Link>
            <Link to='/about-rsbcl-organization'>about-rsbcl-organization</Link>
            <Link to='/about-rsbcl-memorandom'>about-rsbcl-memorandom</Link>
            <Link to='/about-rsgsm'>about-rsgsm</Link>
            <Link to='/directory-excise-head-office'>directory-excise-head-office</Link>
            <Link to='/directory-excise-deo-office'>directory-excise-deo-office</Link>
            <Link to='/directory-excise-circle-office'>directory-excise-circle-office</Link>
            <Link to='/directory-excise-zone-office'>directory-excise-zone-office</Link>
            <Link to='/directory-rsgsm-sugar-mill'>directory-rsgsm-sugar-mill</Link>
            <Link to='/directory-rsgsm-reduction-center'>directory-rsgsm-reduction-center</Link>
            <Link to='/directory-rsgsm-depots'>directory-rsgsm-depots</Link>
            <Link to='/directory-rsgsm-head-office'>directory-rsgsm-head-office</Link>
            <Link to='/directory-rsbcl-depots'>directory-rsbcl-depots</Link>
            <Link to='/directory-rsbcl-head-office'>directory-rsbcl-head-office</Link>
            <Link to='/mobile-app'>mobile-app</Link>
            <Link to='/contact-us'>contact-us</Link>
            <Link to='/excise-login'>excise-login</Link>
            <Link to='/rsbcl-login'>rsbcl-login</Link>
            <Link to='/rsgsm-login'>rsgsm-login</Link>
            <Link to='/'></Link>
            <Link to='/'></Link>
        </div>
    )
}

export default Links
