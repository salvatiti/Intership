using System;

namespace GradeBook
{
    class Program
    {
        static void Main(string[] args)
        {

            Book book = new Book();
            book.AddGrade(45.4);
            book.AddGrade(20.2);
            book.AddGrade(11.4);


            var stats = book.getStatistics();

            Console.WriteLine($"The highest grade is {stats.High}");
            Console.WriteLine($"The lowest grade is {stats.Low}");
            Console.WriteLine($"The avg is {stats.Average:N1}");

        }
    }
}