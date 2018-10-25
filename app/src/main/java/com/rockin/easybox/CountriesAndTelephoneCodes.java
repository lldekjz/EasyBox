package com.rockin.easybox;

public class CountriesAndTelephoneCodes {

    public static final String[] countries = {"India", "Afghanistan", "Albania", "Algeria", "American Samoa",
            "Andorra", "Angola", "Anguilla", "Antarctica", "Antigua and Barbuda", "Argentina", "Armenia",
            "Aruba", "Australia", "Austria", "Azerbaijan", "Bahamas", "Bahrain", "Bangladesh", "Barbados",
            "Belarus", "Belgium", "Belize", "Benin", "Bermuda", "Bhutan", "Bolivia", "Bosnia and Herzegovina",
            "Botswana", "Brazil", "Brunei", "Bulgaria", "Burkina Faso", "Burundi", "Cambodia", "Cameroon",
            "Canada", "Cape Verde", "Cayman Islands", "Central African Rpublic", "Chad", "Chile", "China",
            "Christmas Island", "Cocos Island", "Colombia", "Comoros", "Congo", "Congo", "Cook Island",
            "Costa rica", "Cote D'Ivoire", "Croatia", "Cuba", "Cyprus", "Czech Republic", "Denmark",
            "Djibouti", "Dominica", "Dominican Republic", "East Timor", "Ecuador", "Egypt", "El Salvador",
            "Equatorial Guinea", "Eritrea", "Estonia", "Ethiopia", "Falkland Islands", "Faroe Islands",
            "Fiji", "Finland", "Guyana", "Haiti", "Honduras", "Hong kong", "Hungary", "Iceland", "Indonesia",
            "Iran", "Iraq", "Ireland", "Israel", "Italy", "Jamaica", "Japan", "Jordan", "Kazakstan",
            "Kenya", "Kiribati", "Korea South", "Korea North", "Kuwait", "Kyrgyzstan", "Lao people's republic",
            "Latvia", "Lebanon", "Lesotho", "Liberia", "Libya", "Liechtenstein", "Lithuania", "Luzembourg",
            "Mozambique", "Myanmar", "Namibia", "Nauru", "Nepal", "Netherlands", "Neatherlands Antilles",
            "New Caledonia", "New Zealand", "Nicaragua", "Niger", "Nigeria", "Niue", "Norfolk Island",
            "Northern Mariana Islands", "Norway", "Oman", "Pakistan", "Palau", "Palestinian State",
            "Panama", "Papua New Guinea", "Paraguay", "Peru", "Philippines", "Poland", "Portugal", "Puerto Rico",
            "Qatar", "Reunion", "Romania", "Russian Federation", "Rwanda", "Saint Helena", "Saint Kitts and Nevis",
            "Saint Lucia", "Saint Pierre and Miquelon", "Saint Vincent and Grenadines", "Samoa", "San Marino",
            "Sao Tome and Principe", "Saudi Arabia", "Senegal", "Seychelles", "Sierra Leone", "Singapore",
            "Slovakia", "Slovenia", "Soloman Islands", "Somalia", "South Africa", "Spain", "Sri Lanka",
            "Sudan", "Suriname", "Swaziland", "Sweden", "Switzerland", "Syria", "Taiwan", "Tajikistan",
            "Tanzania", "Thailand", "Tokelau", "Tonga", "Trinidad and Tobago", "Virgin Islands", "Wallis and Futuna Islands",
            "Yemen", "Zambia", "Zimbabwe", " "

    };

    public static final String[] telephone_codes = {"91", "93", "355", "213", "1-684", "376", "244",
            "1-264", "672", "1-268", "54", "374", "297", "61", "43", "994", "1-242", "973", "880", "1-246",
            "375", "32", "501", "229", "1-441", "975", "591", "387", "267", "55", "673", "359", "226",
            "257", "855", "237", "1", "238", "1-345", "236", "235", "56", "86", "53", "61", "57", "269",
            "243", "242", "682", "506", "225", "385", "53", "357", "420", "45", "253", "1-767", "1-809",
            "670", "593", "20", "503", "240", "291", "372", "251", "500", "298", "679", "358", "592",
            "509", "504", "852", "36", "354", "62", "98", "964", "353", "972", "39", "1-876", "81",
            "962", "7", "254", "686", "850", "82", "965", "996", "856", "371", "961", "266", "231",
            "218", "423", "370", "352", "258","95", "264", "674", "977", "31", "599", "687", "64", "505",
            "227", "234", "683", "672", "1-670", "47", "968", "92", "680", "970", "570", "675", "595",
            "51", "63", "48", "351", "1-787", "974", "262", "40", "7", "250", "290", "1-869", "1-758",
            "508", "1-784", "685", "378", "239", "966", "221", "248", "232", "65", "421", "386", "677",
            "252", "27", "34", "94", "249", "597", "268", "46", "41", "963", "886", "992", "255", "66",
            "690", "676", "1-868", "1-340", "681", "967", "260", "263"

    };

    public static int find_telephone_code_index(String telephone_code){

        int i;
        for(i = 0; i < telephone_codes.length; i++){
            if (telephone_codes[i].equals(telephone_code)){
                return i;
            }
        }
        return -1;

    }

}
