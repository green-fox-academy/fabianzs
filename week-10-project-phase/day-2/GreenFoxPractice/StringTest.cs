using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace GreenFoxPractice
{
    class StringTest
    {
        public static bool CompareStrings()
        {
            string test = "testvalue";
            return(test.Equals("TESTVALUE", StringComparison.CurrentCultureIgnoreCase));
        }

        public static string ReverseString(string original)
        {
            return new string(original.Reverse().ToArray());
            //return string.Join("",original.ToCharArray().Reverse());
        }

        public static string TakesLonger(string quote)
        { 
            return new StringBuilder(quote).Insert(quote.IndexOf(" you"), " always takes longer than").ToString();
        }

    }
}
