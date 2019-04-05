using System;
using System.Collections.Generic;
using System.Linq;
using System.Linq.Expressions;
using System.Text;
using System.Threading.Tasks;

namespace DelegatePractice
{
    delegate void MyDelegate();
    delegate double CalculateArea(int r);

    class Program
    {
        static void Main(string[] args)
        {
            //DELEGATES
            
            //MyDelegate del = new MyDelegate(Foo);
            //del.Invoke();

            MyDelegate del = Foo;
            //del();
            InvokeMyDelegate(del);

            InvokeMyDelegate(Foo);
            InvokeMyDelegate(Goo);

            //CalculateArea cpointer = new CalculateArea(
            //                        delegate (int r)
            //                        {
            //                            return 3.14 * r * r;
            //                        }
            //                        );
            //double Area = cpointer(20);

            //CalculateArea cpointer = r => 3.14 * r * r;
            //double Area = cpointer(20);


            //FUNCTIONS

            Func<Double, Double> cpointer = r => 3.14 * r * r;
            double Area = cpointer(20);


            //ACTIONS

            Action<string> MyAction = y => Console.Write(y);
            MyAction("Hello!");


            //PREDICATES

            Predicate<string> CheckLongerThan5 = x => x.Length > 5;
            CheckLongerThan5("Does this work?");

            List<string> stringsToCheck = new List<string>();
            stringsToCheck.Add("Is it longer?");
            stringsToCheck.Add("Than 5");
            stringsToCheck.Add("No.");

            string shortString = stringsToCheck.Find(CheckLongerThan5);


            //EXPRESSION TREES
            //(10 + 20) - (5 + 3)

            BinaryExpression b1 = Expression.MakeBinary(ExpressionType.Add,
                                                        Expression.Constant(10),
                                                        Expression.Constant(20));
            BinaryExpression b2 = Expression.MakeBinary(ExpressionType.Add,
                                                        Expression.Constant(5),
                                                        Expression.Constant(3));
            BinaryExpression b3 = Expression.MakeBinary(ExpressionType.Subtract,
                                                        b1,
                                                        b2);

            int result = Expression.Lambda<Func<int>>(b3).Compile()();

            Console.ReadKey();
        }

        static void InvokeMyDelegate(MyDelegate del)
        {
            del();
        }

        static void Foo()
        {
            Console.WriteLine("Foo()");
        }

        static void Goo()
        {
            Console.WriteLine("Goo()");
        }

        public T DoSomething<T>(T input, T input2)
        {
            dynamic s1 = input;
            dynamic s2 = input2;
            return s1 + s2;
        }

        public T DoSomething<T>(dynamic input, dynamic input2)
        {
            return input + input2;
        }
    }
}
